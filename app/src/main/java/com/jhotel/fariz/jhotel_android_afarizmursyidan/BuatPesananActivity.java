package com.jhotel.fariz.jhotel_android_afarizmursyidan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class BuatPesananActivity extends AppCompatActivity {
    private int customer_id;
    private int banyakHari;
    private int idHotel;
    private double tarif;
    private String roomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_pesanan);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        customer_id = (int) b.get("id_customer");
        roomNumber = (String) b.get("nomorKamar");
        idHotel = (int) b.get("id_hotel");
        tarif = (double) b.get("tariff");

        final TextView room_number = (TextView) findViewById(R.id.room_number);
        final TextView tariff = (TextView) findViewById(R.id.tariff);
        final EditText durasi_hari = (EditText) findViewById(R.id.durasi_hari);
        final TextView total_biaya = (TextView) findViewById(R.id.total_biaya);
        final Button hitung = (Button) findViewById(R.id.hitung);
        final Button pesan = (Button) findViewById(R.id.pesan);

        pesan.setVisibility(View.GONE);
        room_number.setText(roomNumber);
        tariff.setText(""+tarif);
        total_biaya.setText("0");

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                banyakHari = Integer.parseInt(durasi_hari.getText().toString());
                double total = tarif*banyakHari;
                total_biaya.setText(""+total);
                hitung.setVisibility(View.GONE);
                pesan.setVisibility(View.VISIBLE);
            }
        });

        pesan.setOnClickListener(new View.OnClickListener() {

            final String jumlah_hari = banyakHari+"";
            final String nomor_kamar = roomNumber;
            final String id_customer = customer_id+"";
            final String id_hotel = idHotel+"";

            @Override
            public void onClick(View v) {

                Response.Listener<String> responseListener = new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            if(jsonResponse!=null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(BuatPesananActivity.this);
                                builder.setMessage("Pesanan Success")
                                        .create()
                                        .show();
                                Intent intent = new Intent(BuatPesananActivity.this, MainActivity.class);
                                BuatPesananActivity.this.startActivity(intent);
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(BuatPesananActivity.this);
                            builder.setMessage("Pesanan Failed")
                                    .create()
                                    .show();
                        }
                    }
                };
                BuatPesananRequest buatPesananRequest = new BuatPesananRequest(banyakHari+"", id_customer, id_hotel, nomor_kamar, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BuatPesananActivity.this);
                queue.add(buatPesananRequest);
            }
        });
    }
}
