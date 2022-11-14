package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//14. @Scope Annotation
//Explicitly Specify Bean Scope
//@Scope("Singleton")
//@Scope("prototype") It's gonna create a new object for each request. and I give the actual scope in parens or quotes here. 
public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("file:src/applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
	
		// check if they are the same object
		boolean result = (theCoach ==  alphaCoach);
		
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory location for theCoach: "+theCoach);
		
		System.out.println("\nMemory location for alphaCoach: "+alphaCoach);
		
		// close the context
		context.close();
	}
//	here is a subtle point you need to be aware of with "prototype" scoped beans
//
//	For "prototype" scoped beans, Spring does not call the @PreDestroy method.
//
//	In Contract to the other scopes, Spring does not manage the complete lifecycle of a prototype bean:
//	the container instantiates, configures, and otherwise assemble a prototype object, and hands it to the client, with not further record of the prototype instance.
//
//	Thus although init lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifcycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding.
//
//	Q: How can i create code to call the destroy method on prototype scope beans?
//	Ans: You can destroy prototype beans but custom coding is required,
//	1. Create a custom bean processor. This bean processor will keep track of prototype scoped beans. During shutdown it will call the destroy() method on the prototype scoped beans.
//
//	@Component
//	public class MyCustomBeanProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean {
//		private BeanFactory beanFactory;
//
//		private final List<Object> prototypeBeans = new LinkedList<>();
//
//		@Override
//		public Object postProcessAfterInitialization(Object bean, String beanName) throw BeansException {
//			// after start up, keep track of the prototype scoped beans
//			// we will need to know who they are for later destruction
//
//			if (beanFactory.isPrototype(beanName)){
//				synchronized(prototypeBeans){
//					prototypeBeans.add(bean);
//				}
//			}
//			return bean;
//		}
//		@Override
//		public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//			this.beanFactory = beanFactory;
//		}
//
//		@Override
//		public void destroy() throws Exception {
//			// loop through the prototype beans and call the destroy() method on each one
//			synchronized(prototypeBeans) {
//				for(Object bean:prototypeBeans){
//					if(bean instanceof DisposableBean){
//						DisposableBean disposable = (DisposableBean)bean;
//						try {
//							disposable.destroy();
//						} catch (Exception e){
//							e.printStackTrace();
//						}
//					}
//				}
//				prototypeBeans.clear();
//			}
//		}
//	}
//
//	2. The prototype scoped beans MUST implement the DisposableBean interface. This interface define a "destroy()" method. This method should be used instead of the @PreDestroy
//
//	@Component
//	@Scope("prototype")
//	public class TennisCoach implements Coach.DisposableBean {
//		@Autowired
//		private FortuneService fortuneService;
//
//		@PostConstruct
//		public void doMyStartupStuff() {
//			sysout(">> TennisCoach: inside doMyStartupStuff")
//
//		}
//
//		@Override
//		public String getDailyWorkout() {
//			return "Practice your backend volley"
//		}
//
//		@Override
//		public String getDailyFortune() {
//			return fortuneService.getForturne()
//		}
//
//		@Override
//		public void destroy() throw Eception {
//			sysout(">> TennisCoach: inside destroy()")
//		}
//	}
//
//	3. In this app, BeanProcessDemoApp.java is the main program. TennisCoach.java is the prototype scoped bean. TennisCoach implements the DisposableBean interface and provides the destroy() method. The custom bean processing is handled in the MyCustomBeanProcessor class.
//
//	public class BeanProcessorDemoApp {
//		public static void main(String[] arg){
//
//			// load spring config file
//			ClassPathXmlApplicationContext context = 
//				new ClassPathXmlApplicationContext("applicationContext.xml");
//			// retrieve bean from spring container
//			Coach theCoach = context.getBean("tennisCoach", Coach.class);
//
//			sysout("Daily workout: "+theCoach.getDailyWorkout());
//
//			// close the context
//			context.close();
//		}
//	}
}
