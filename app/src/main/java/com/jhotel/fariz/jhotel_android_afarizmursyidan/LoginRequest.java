package com.jhotel.fariz.jhotel_android_afarizmursyidan;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fariz on 01/05/2018.
 */

public class LoginRequest extends StringRequest {
    private static final String Login_URL = "http://192.168.1.103:8080/logincust";
    private Map<String, String> params;

    public LoginRequest(String email, String password,
                           Response.Listener<String> listener) {
        super(Method.POST, Login_URL, listener, null);
        params = new HashMap<>();
        params.put("email",email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
