package com.jhotel.fariz.jhotel_android_afarizmursyidan;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fariz on 10/05/2018.
 */

public class CustomerFetchRequest extends StringRequest {
    private static final String CustomerFetch_URL = "http://192.168.1.100:8080/getcustomer/";
    private Map<String, String> params;

    public CustomerFetchRequest(Response.Listener<String> listener, String id_customer) {
        super(Request.Method.GET, CustomerFetch_URL+id_customer, listener, null);
        params = new HashMap<>();
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
