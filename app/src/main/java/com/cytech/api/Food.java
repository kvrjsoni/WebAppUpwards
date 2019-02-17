package com.cytech.api;

import java.io.Serializable;

/**
 * POJO for Food Data
 */
public class Food implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String name;
    public String brand_name;
    public String size;

}
