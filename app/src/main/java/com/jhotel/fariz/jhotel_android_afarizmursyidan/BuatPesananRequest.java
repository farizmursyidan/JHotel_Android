package com.jhotel.fariz.jhotel_android_afarizmursyidan;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fariz on 04/05/2018.
 */

public class BuatPesananRequest extends StringRequest {
    private static final String Pesanan_URL = "http://192.168.1.103:8080/bookpesanan";
    private Map<String, String> params;

    public BuatPesananRequest(String jumlah_hari, String id_customer, String id_hotel, String nomor_kamar,
                           Response.Listener<String> listener) {
        super(Method.POST, Pesanan_URL, listener, null);
        params = new HashMap<>();
        params.put("jumlah_hari", jumlah_hari);
        params.put("id_customer", id_customer);
        params.put("id_hotel", id_hotel);
        params.put("nomor_kamar", nomor_kamar);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
