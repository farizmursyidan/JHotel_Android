package com.jhotel.fariz.jhotel_android_afarizmursyidan;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fariz on 06/05/2018.
 */

public class PesananBatalRequest extends StringRequest {
    private static final String PesananBatal_URL = "http://192.168.1.103:8080/cancelpesanan/";
    private Map<String, String> params;

    public PesananBatalRequest(String id_pesanan, Response.Listener<String> listener) {
        super(Method.POST, PesananBatal_URL, listener, null);
        params = new HashMap<>();
        params.put("id_pesanan", id_pesanan);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
