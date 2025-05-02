package com.aithinkers.Spring.MVC.Thymeleaf.Model;

public class Student {
    private String first_name;
    private String last_name;
    private String country;
    private String favouriteLanguages;
    private String favouriteOS;

    public Student() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguages() {
        return favouriteLanguages;
    }

    public void setFavouriteLanguages(String favouriteLanguages) {
        this.favouriteLanguages = favouriteLanguages;
    }

    public String getFavouriteOS() {
        return favouriteOS;
    }

    public void setFavouriteOS(String favouriteOS) {
        this.favouriteOS = favouriteOS;
    }
}
