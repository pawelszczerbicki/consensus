package com.szczerbicki.clustering;

/**
 * Created by Pawel on 2014-12-14.
 */
public class Centroid {
    private double mX = 0.0;
    private double mY = 0.0;

    public Centroid() {
    }

    public Centroid(double newX, double newY) {
        this.mX = newX;
        this.mY = newY;
    }

    public void X(double newX) {
        this.mX = newX;
    }

    public double X() {
        return this.mX;
    }

    public void Y(double newY) {
        this.mY = newY;
    }

    public double Y() {
        return this.mY;
    }
}
