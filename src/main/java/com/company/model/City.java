package com.company.model;

public class City {

    private int id ;
    private String name;
    private String city_measures;
    private int countryId;
    private int peopleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity_measures() {
        return city_measures;
    }

    public void setCity_measures(String city_measures) {
        this.city_measures = city_measures;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city_measures='" + city_measures + '\'' +
                ", countryId=" + countryId +
                ", peopleId=" + peopleId +
                '}';

    }}
