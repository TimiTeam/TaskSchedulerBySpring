package com.apress.prospring4.ch11.service.interfaces;


import com.apress.prospring4.ch11.components.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();
}
