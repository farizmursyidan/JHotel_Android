package com.jhotel.fariz.jhotel_android_afarizmursyidan;

/**
 * Created by Fariz on 03/05/2018.
 */

public class Hotel {
    private int id;
    private String nama;
    private Lokasi lokasi;
    private int bintang;

    /**
     * Method ini merupakan constructor untuk meng-assign instance variable
     * @param nama ini adalah parameter untuk menentukan nama pelanggan
     * @param lokasi ini adalah parameter untuk menentukan lokasi hotel
     * @param bintang ini adalah parameter untuk memberikan bintang hotel
     * @return tidak ada
     */

    public Hotel(String nama, Lokasi lokasi, int bintang, int id)
    {
        this.nama = nama;
        this.lokasi = lokasi;
        this.bintang = bintang;
        this.id = id;
    }

    public int getID()
    {
        return id;
    }

    /**
     * Method ini adalah accessor untuk mengembalikan nilai bintang hotel
     * @return bintang mengembalikan nilai bintang hotel
     */

    public int getBintang()
    {
        return bintang;
    }

    /**
     * Method ini adalah accessor untuk mengembalikan nama hotel
     * @return nama mengembalikan nama hotel
     */

    public String getNama()
    {
        return nama;
    }

    /**
     * Method ini adalah accessor untuk mengembalikan lokasi hotel
     * @return lokasi mengembalikan lokasi hotel
     */

    public Lokasi getLokasi()
    {
        return lokasi;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    /**
     * Method ini adalah mutator untuk menetapkan nama hotel
     * @param nama adalah nama hotel
     */

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    /**
     * Method ini adalah mutator untuk menetapkan lokasi hotel
     * @param lokasi adalah lokasi hotel
     */

    public void setLokasi(Lokasi lokasi)
    {
        this.lokasi = lokasi;
    }

    /**
     * Method ini adalah mutator untuk menetapkan bintang hotel
     * @param bintang adalah bintang hotel
     */

    public void setBintang(int bintang)
    {
        this.bintang = bintang;
    }
}
