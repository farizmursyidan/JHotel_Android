package com.jhotel.fariz.jhotel_android_afarizmursyidan;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fariz on 06/05/2018.
 */

public class PesananSelesaiRequest extends StringRequest {
    private static final String PesananSelesai_URL = "http://192.168.1.100:8080/finishpesanan/";
    private Map<String, String> params;

    public PesananSelesaiRequest(String id_pesanan, Response.Listener<String> listener) {
        super(Method.POST, PesananSelesai_URL, listener, null);
        params = new HashMap<>();
        params.put("id_pesanan", id_pesanan);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
