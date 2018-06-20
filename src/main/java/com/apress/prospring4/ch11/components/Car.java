package com.apress.prospring4.ch11.components;


import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    private Long id;
    private int version;
    private String licensePlate;
    private String manufacturer;
    private DateTime manufactureDate;
    private int age;


    public Car() {
    }

    public Car(String licensePlate, String manufacturer, DateTime manufactureDate) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    @Column(name = "license_plate")
    public String getLicensePlate() {
        return licensePlate;
    }

    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "manufacture_date")
    public DateTime getManufactureDate() {
        return manufactureDate;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setManufactureDate(DateTime manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "License: "+getLicensePlate()+", - "+
                "Manufacturer: "+getManufacturer()+" - "+
                "Date: "+getManufactureDate()+" - "+
                "Age: "+getAge();
    }
}
