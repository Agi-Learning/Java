package com.javatechie.spring.cloud.task.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskExampleApplication implements CommandLineRunner, TaskExecutionListener {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskExampleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to "+ args[0] +" Spring Cloud Task Example");
	}

	@Override
	public void onTaskStartup(TaskExecution taskExecution) {
		System.out.println("TaskName : " + taskExecution.getTaskName()+ ", TaskId : " + taskExecution.getExecutionId() + " started!");
		
	}

	@Override
	public void onTaskEnd(TaskExecution taskExecution) {
		System.out.println("TaskName : " + taskExecution.getTaskName()+ ", TaskId : " + taskExecution.getExecutionId() + " Completed...");
		
	}

	@Override
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		System.out.println("TaskName : " + taskExecution.getTaskName()+ ", TaskId : " + taskExecution.getExecutionId() + " Failed due to " + throwable.getMessage());
		
	}
}
