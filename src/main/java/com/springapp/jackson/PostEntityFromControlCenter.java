package com.springapp.jackson;

public class PostEntityFromControlCenter {

    private String radial_distance;

    private String polar_angle;

    private String azimuth_angle;

    private String number;

    public PostEntityFromControlCenter() {}

    public PostEntityFromControlCenter(String radial_distance, String polar_angle, String azimuth_angle, String number) {
        this.radial_distance = radial_distance;
        this.polar_angle = polar_angle;
        this.azimuth_angle = azimuth_angle;
        this.number = number;
    }

    public String getRadial_distance() {
        return radial_distance;
    }

    public void setRadial_distance(String radial_distance) {
        this.radial_distance = radial_distance;
    }

    public String getPolar_angle() {
        return polar_angle;
    }

    public void setPolar_angle(String polar_angle) {
        this.polar_angle = polar_angle;
    }

    public String getAzimuth_angle() {
        return azimuth_angle;
    }

    public void setAzimuth_angle(String azimuth_angle) {
        this.azimuth_angle = azimuth_angle;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
