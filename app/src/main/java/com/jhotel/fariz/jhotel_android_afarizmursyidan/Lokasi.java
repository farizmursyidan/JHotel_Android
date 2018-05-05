package com.jhotel.fariz.jhotel_android_afarizmursyidan;

/**
 * Created by Fariz on 03/05/2018.
 */

public class Lokasi {
    private double x_coord;
    private double y_coord;
    private String deskripsi;

    public Lokasi(double x_coord, double y_coord, String deskripsi)
    {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.deskripsi = deskripsi;
    }

    public double getX()
    {
        return x_coord;
    }

    /**
     * Method ini adalah accessor untuk mengembalikan nilai koordinat y
     * @return y_coord mengembalikan nilai koordinat y
     */

    public double getY()
    {
        return y_coord;
    }

    /**
     * Method ini adalah accessor untuk mengembalikan deskripsi lokasi
     * @return deskirpsiLokasi mengembalikan nilai koordinat x
     */

    public String getDeskripsi()
    {
        return deskripsi;
    }

    /**
     * Method ini adalah mutator untuk menetapkan nilai koordinat x
     * @param x_coord adalah nilai koordinat x
     */

    public void setX(double x_coord)
    {
        this.x_coord = x_coord;
    }

    /**
     * Method ini adalah mutator untuk menetapkan nilai koordinat y
     * @param y_coord adalah nilai koordinat y
     */

    public void setY(double y_coord)
    {
        this.y_coord = y_coord;
    }

    /**
     * Method ini adalah mutator untuk menetapkan deskripsi lokasi
     * @param deskripsi adalah deskripsi lokasi hotel
     */

    public void setDeskripsi(String deskripsi)
    {
        this.deskripsi = deskripsi;
    }
}
