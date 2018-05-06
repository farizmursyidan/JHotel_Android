package com.jhotel.fariz.jhotel_android_afarizmursyidan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.toolbox.Volley.newRequestQueue;

/**
 * Created by Fariz on 06/05/2018.
 */

public class SelesaiPesananActivity extends AppCompatActivity {
    int currentUserId;
    public static String idPesanan;
    int biaya1;
    int jumlahHari;
    String tanggalPesan;
    public static TextView staticIdPesanan;
    public static TextView staticBiaya;
    public static TextView staticJumlahHari;
    public static TextView staticTanggalPesan;
    public static TextView id_pesanan;
    public static TextView biaya;
    public static TextView jumlah_hari;
    public static TextView tanggal_pesan;
    public static Button batal;
    public static Button selesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai_pesanan);

        Intent intent = getIntent();
        currentUserId = intent.getIntExtra("customer_id", 0);

        staticIdPesanan = (TextView) findViewById(R.id.staticIdPesanan);
        staticBiaya = (TextView) findViewById(R.id.staticBiaya);
        staticJumlahHari = (TextView) findViewById(R.id.staticJumlahHari);
        staticTanggalPesan = (TextView) findViewById(R.id.staticTanggalPesan);
        id_pesanan = (TextView) findViewById(R.id.id_pesanan);
        biaya = (TextView) findViewById(R.id.biaya);
        jumlah_hari = (TextView) findViewById(R.id.jumlah_hari);
        tanggal_pesan = (TextView) findViewById(R.id.tanggal_pesan);
        batal = (Button) findViewById(R.id.batal);
        selesai = (Button) findViewById(R.id.selesai);

        staticIdPesanan.setVisibility(View.GONE);
        staticBiaya.setVisibility(View.GONE);
        staticJumlahHari.setVisibility(View.GONE);
        staticTanggalPesan.setVisibility(View.GONE);
        id_pesanan.setVisibility(View.GONE);
        biaya.setVisibility(View.GONE);
        jumlah_hari.setVisibility(View.GONE);
        tanggal_pesan.setVisibility(View.GONE);
        batal.setVisibility(View.GONE);
        selesai.setVisibility(View.GONE);

        fetchPesanan();

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            if(jsonResponse!=null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SelesaiPesananActivity.this);
                                builder.setMessage("Pesanan Berhasil Dibatalkan")
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(SelesaiPesananActivity.this);
                            builder.setMessage("Pesanan Gagal Dibatalkan")
                                    .create()
                                    .show();
                        }
                    }
                };
                PesananBatalRequest pesananBatalRequest = new PesananBatalRequest(SelesaiPesananActivity.idPesanan,responseListener);
                RequestQueue queue = Volley.newRequestQueue(SelesaiPesananActivity.this);
                queue.add(pesananBatalRequest);
            }
        });

        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            if(jsonResponse!=null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SelesaiPesananActivity.this);
                                builder.setMessage("Pesanan Berhasil Diselesaikan")
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(SelesaiPesananActivity.this);
                            builder.setMessage("Pesanan Gagal Diselesaikan")
                                    .create()
                                    .show();
                        }
                    }
                };
                PesananSelesaiRequest pesananSelesaiRequest = new PesananSelesaiRequest(SelesaiPesananActivity.idPesanan,responseListener);
                RequestQueue queue = Volley.newRequestQueue(SelesaiPesananActivity.this);
                queue.add(pesananSelesaiRequest);
            }
        });
    }

    public void fetchPesanan() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (response.equals("")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(SelesaiPesananActivity.this);
                        builder.setMessage("Pesanan Tidak Ditemukan!")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(SelesaiPesananActivity.this, MainActivity.class);
                                        intent.putExtra("id", currentUserId);
                                        SelesaiPesananActivity.this.startActivity(intent);

                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }else {
                        JSONObject jsonResponse = new JSONObject(response);
                        if (jsonResponse != null) {
                            staticIdPesanan.setVisibility(View.VISIBLE);
                            staticBiaya.setVisibility(View.VISIBLE);
                            staticJumlahHari.setVisibility(View.VISIBLE);
                            staticTanggalPesan.setVisibility(View.VISIBLE);
                            id_pesanan.setVisibility(View.VISIBLE);
                            biaya.setVisibility(View.VISIBLE);
                            jumlah_hari.setVisibility(View.VISIBLE);
                            tanggal_pesan.setVisibility(View.VISIBLE);
                            batal.setVisibility(View.VISIBLE);
                            selesai.setVisibility(View.VISIBLE);
                            setUpView(jsonResponse);
                        }
                    }


                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        };
        PesananFetchRequest pesananFetchRequest = new PesananFetchRequest(responseListener, currentUserId + "");
        RequestQueue queue = newRequestQueue(SelesaiPesananActivity.this);
        queue.add(pesananFetchRequest);
    }


    public void setUpView(JSONObject object) {
        try {
            id_pesanan.setText(object.getString("id"));
            idPesanan = object.getString("id");
            biaya.setText(object.getString("biaya"));
            jumlah_hari.setText(object.getString("jumlahHari"));
            tanggal_pesan.setText(object.getString("tanggalPesan"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
