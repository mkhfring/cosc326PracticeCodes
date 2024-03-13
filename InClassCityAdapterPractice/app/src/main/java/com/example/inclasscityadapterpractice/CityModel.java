package com.example.inclasscityadapterpractice;

public class CityModel {
    private String cityName;
    private String population;
    private int imageSource;

    public CityModel(String cityName, String population, int imageSource) {
        this.cityName = cityName;
        this.population = population;
        this.imageSource = imageSource;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getImageSource() {
        return imageSource;
    }

    public void setImageSource(int imageSource) {
        this.imageSource = imageSource;
    }
}
