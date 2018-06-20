package com.apress.prospring4.ch11;


import com.apress.prospring4.ch11.components.TaskToExecute;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskExecutorSample {
    private static final Logger LOGGER = Logger.getLogger(TaskExecutorSample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task-executor-app-context.xml");

        TaskToExecute execute = context.getBean(TaskToExecute.class);

        execute.executeTask();

    }
}
