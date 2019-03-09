package com.nobel.model;


public class Laureate {

    private Integer id;
    private String first_name;
    private String last_name;
    private String born;
    private String died = "Alive";
    private String born_country;
    private String born_country_code;
    private String born_city;
    private String died_country;
    private String died_country_code;
    private String gender;
    private Integer prize_year;
    private String category;
    private String motivation;

    public boolean isNew() {
        return id == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getBorn_country() {
        return born_country;
    }

    public void setBorn_country(String born_country) {
        this.born_country = born_country;
    }

    public String getBorn_country_code() {
        return born_country_code;
    }

    public void setBorn_country_code(String born_country_code) {
        this.born_country_code = born_country_code;
    }

    public String getBorn_city() {
        return born_city;
    }

    public void setBorn_city(String born_city) {
        this.born_city = born_city;
    }

    public String getDied_country() {
        return died_country;
    }

    public void setDied_country(String died_country) {
        this.died_country = died_country;
    }

    public String getDied_country_code() {
        return died_country_code;
    }

    public void setDied_country_code(String died_country_code) {
        this.died_country_code = died_country_code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPrize_year() {
        return prize_year;
    }

    public void setPrize_year(Integer prize_year) {
        this.prize_year = prize_year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

}
