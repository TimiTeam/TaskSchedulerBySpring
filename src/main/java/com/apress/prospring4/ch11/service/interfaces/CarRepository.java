package com.apress.prospring4.ch11.service.interfaces;


import com.apress.prospring4.ch11.components.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long>{
}
