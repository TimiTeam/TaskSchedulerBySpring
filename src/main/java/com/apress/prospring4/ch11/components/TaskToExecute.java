package com.apress.prospring4.ch11.components;


import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

public class TaskToExecute {
    private static final Logger LOG = Logger.getLogger(TaskToExecute.class);

    private TaskExecutor taskExecutor;

    public void executeTask() {
        for (int i = 0; i < 10; i++) {
            taskExecutor.execute(new Runnable() {
                public void run() {
                    LOG.info("Hello from thread: "+Thread.currentThread().getName());
                }
            });
        }
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }
}
