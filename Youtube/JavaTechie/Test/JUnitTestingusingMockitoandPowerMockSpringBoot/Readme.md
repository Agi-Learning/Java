# JUnit Testing using Mockito and Power Mock  - SpringBoot | JavaTechie

* Today, you're going to discuss about Tawarma api. So what exactly? Powermac api and five innate powermock api, even though we have mock ito frameworks OK, so basically with the help of power Mark KPA, we can mark any of our strategic final or private method which we can do with the help of marketer framework. So we can say this is 1 limitation in market framework to overcome this issue. Power mark came into the picture so that we can play around the reflection api and we can mop any of our static, private and final method So let us understand the power mark api with example. Already I have created one example where we have 1 controller. Run on surface with the controller. This is my controller place order. The request is order request, and it will call the selfies. So lets go to the service. In service, I do not have any business. Even identity database layer, simply the object I am getting from the control of cm. I am returning here with some status code. So let us add three of the private, static and final method here so that we can write the test case with the help of our mode So let us Consider the huge case something like once the order will be placed. We need to trigger a notification to the particular user So that's why I write one UT class with UT class. We have one static mouth with the help of power. Now you are going to write the test case for this static method, ok? So this method do not have any logic, just the method argument. And I am forcefully returning success here. If you want, you can connect the German mail center, ok?