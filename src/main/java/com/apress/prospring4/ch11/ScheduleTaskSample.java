package com.apress.prospring4.ch11;

import com.apress.prospring4.ch11.components.Car;
import com.apress.prospring4.ch11.service.interfaces.AsyncService;
import com.apress.prospring4.ch11.service.interfaces.CarService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ScheduleTaskSample {
    private static final Logger LOGGER = Logger.getLogger(ScheduleTaskSample.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("async-app-context.xml");

        AsyncService service = context.getBean("asyncService", AsyncService.class);

        for (int i = 0; i < 5; i++) {
            service.asyncTask();
        }

        Future<String> future1 = service.asyncWithReturn("Timur");
        Future<String> future2 = service.asyncWithReturn("Natalia");
        Future<String> future3 = service.asyncWithReturn("Jack");

        try {
            Thread.sleep(6000);
            LOGGER.info("Future1: "+future1.get());
            LOGGER.info("Future2: "+future2.get());
            LOGGER.info("Future3: "+future3.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static void listAll(List<Car> carList) {
        LOGGER.info("List all cars: ");
        for (Car c : carList) {
            LOGGER.info(c);
        }
    }

}
