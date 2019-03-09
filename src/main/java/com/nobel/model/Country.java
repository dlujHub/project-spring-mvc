package com.nobel.model;

public class Country {

    private String name;
    private Integer nrOfNobelLaureates;
    private Integer population;
    private Integer laureatesPer10Mln;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNrOfNobelLaureates() {
        return nrOfNobelLaureates;
    }

    public void setNrOfNobelLaureates(Integer nrOfNobelLaureates) {
        this.nrOfNobelLaureates = nrOfNobelLaureates;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getLaureatesPer10Mln() {
        return laureatesPer10Mln;
    }

    public void setLaureatesPer10Mln(Integer laureatesPer10Mln) {
        this.laureatesPer10Mln = laureatesPer10Mln;
    }
}
