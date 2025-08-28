package com.worldpopulation;

public class Country {
    private String countryName, capitalName, regionName, subregionName;

    public Country(String countryName, String capitalName, String regionName, String subregionName) {
        this.countryName = countryName;
        this.capitalName = capitalName;
        this.regionName = regionName;
        this.subregionName = subregionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getSubregionName() {
        return subregionName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", capitalName='" + capitalName + '\'' +
                ", regionName='" + regionName + '\'' +
                ", subregionName='" + subregionName + '\'' +
                '}';
    }
}
