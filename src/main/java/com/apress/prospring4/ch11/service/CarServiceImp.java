package com.apress.prospring4.ch11.service;


import com.apress.prospring4.ch11.components.Car;
import com.apress.prospring4.ch11.service.interfaces.CarRepository;
import com.apress.prospring4.ch11.service.interfaces.CarService;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service("carService")
@Repository
@Transactional
public class CarServiceImp implements CarService{

    private static final Logger LOG = Logger.getLogger(CarService.class);

    @Autowired
    CarRepository carRepository;


    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void updateCarAgeJob() {

        List<Car> carList = findAll();
        DateTime currentTime = DateTime.now();
        LOG.info("Car age update job started");

        for(Car c: carList){
            int age = Years.yearsBetween(c.getManufactureDate(),currentTime).getYears();
            c.setAge(age);
            save(c);
            LOG.info("Car age update --- "+c);
        }
        LOG.info("Car age is update, the job was completed successfully");
    }
}
