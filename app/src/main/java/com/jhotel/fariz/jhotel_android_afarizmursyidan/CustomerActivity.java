package com.jhotel.fariz.jhotel_android_afarizmursyidan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class CustomerActivity extends AppCompatActivity {
    int currentUserId;
    private int customer_id;
    private String name;
    private String email;

    public static TextView nama;
    public static TextView e_mail;
    public static ImageView profile_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        currentUserId = intent.getIntExtra("customer_id", 0);

        nama = (TextView) findViewById(R.id.name);
        e_mail = (TextView) findViewById(R.id.email);
        profile_picture = (ImageView) findViewById(R.id.profile_picture);

        nama.setVisibility(View.GONE);
        e_mail.setVisibility(View.GONE);

        fetchCustomer();

    }

    public void fetchCustomer() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (response.equals("")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(CustomerActivity.this);
                        builder.setMessage("Pelanggan Tidak Ditemukan!")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(CustomerActivity.this, MainActivity.class);
                                        intent.putExtra("id", currentUserId);
                                        CustomerActivity.this.startActivity(intent);

                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }else {
                        JSONObject jsonResponse = new JSONObject(response);
                        if (jsonResponse != null) {
                            nama.setVisibility(View.VISIBLE);
                            e_mail.setVisibility(View.VISIBLE);
                            setUpView(jsonResponse);
                        }
                    }


                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        };
        CustomerFetchRequest customerFetchRequest = new CustomerFetchRequest(responseListener, currentUserId + "");
        RequestQueue queue = newRequestQueue(CustomerActivity.this);
        queue.add(customerFetchRequest);
    }


    public void setUpView(JSONObject object) {
        try {
            nama.setText(object.getString("nama"));
            e_mail.setText(object.getString("email"));
            String foto = object.getString("photo");
            ImageView imageView = (ImageView) findViewById(R.id.profile_picture);
            Glide.with(CustomerActivity.this).load(foto)
                    .fitCenter() // menyesuaikan ukuran imageview
                    .crossFade() // animasi
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
