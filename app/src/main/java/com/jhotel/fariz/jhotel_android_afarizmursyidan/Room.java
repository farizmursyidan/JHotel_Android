package com.jhotel.fariz.jhotel_android_afarizmursyidan;

/**
 * Created by Fariz on 03/05/2018.
 */

public class Room {
    private String roomNumber;
    private String statusKamar;
    private double dailyTariff;
    private String tipeKamar;

    public Room (String roomNumber, String statusKamar, double dailyTariff, String tipeKamar)
    {
        this.roomNumber = roomNumber;
        this.statusKamar = statusKamar;
        this.dailyTariff = dailyTariff;
        this.tipeKamar = tipeKamar;
    }

    public String getRoomNumber()
    {
        return roomNumber;
    }

    public String getStatusKamar()
    {
        return statusKamar;
    }

    /**
     * Method ini adalah accessor untuk mengembalikan harga per hari sewa kamar
     * @return dailyTariff mengembalikan harga per hari sewa kamar
     */

    public double getDailyTariff()
    {
        return dailyTariff;
    }

    /**
     * Method ini adalah accessor untuk mengembalikan status kamar
     * @return status_kamar mengembalikan status kamar
     */

    public String getTipeKamar()
    {
        return tipeKamar;
    }

    public void setRoomNumber(String roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    /**
     * Method ini adalah mutator untuk menetapkan harga per hari sewa kamar
     * @param dailyTariff adalah harga per hari sewa kamar
     */

    public void setDailyTariff(double dailyTariff)
    {
        this.dailyTariff = dailyTariff;
    }

    /**
     * Method ini adalah mutator untuk menetapkan status kamar
     * @param statusKamar adalah status kamar
     */

    public void setStatusKamar(String statusKamar)
    {
        this.statusKamar = statusKamar;
    }

    public String toString()
    {
        return  "\nNomor Kamar\t\t: " + getRoomNumber() +
                "\nTipe Kamar\t\t\t\t: " + getTipeKamar() +
                "\nHarga\t\t\t\t\t\t\t\t\t\t\t: " + getDailyTariff() +
                "\nStatus Kamar\t\t: " + getStatusKamar();

    }
}
