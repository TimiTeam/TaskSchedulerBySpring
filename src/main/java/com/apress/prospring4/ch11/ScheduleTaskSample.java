package com.apress.prospring4.ch11;

import com.apress.prospring4.ch11.components.Car;
import com.apress.prospring4.ch11.service.interfaces.CarService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ScheduleTaskSample {
    private static final Logger LOGGER = Logger.getLogger(ScheduleTaskSample.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("task-namespace-app-context.xml");

        while (true){

        }
    }

    private static void listAll(List<Car> carList){
        LOGGER.info("List all cars: ");
        for(Car c: carList){
            LOGGER.info(c);
        }
    }

}
