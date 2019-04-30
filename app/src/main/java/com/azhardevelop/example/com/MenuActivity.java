package com.azhardevelop.example.com;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.azhardevelop.example.com.model.ApiServiceCat;
import com.azhardevelop.example.com.model.CatApi;
import com.azhardevelop.example.com.model.GetDataCat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    ProgressDialog dialog;
    private CatAdapter adapter;
    private RecyclerView listCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dialog = new ProgressDialog(MenuActivity.this);
        dialog.setMessage("Load Data Cat....");
        dialog.setTitle("Loading..");
        dialog.show();

        GetDataCat dataCat = CatApi.getRetrofit().create(GetDataCat.class);
        Call<List<ApiServiceCat>> callCat = dataCat.getAllInfo();
        callCat.enqueue(new Callback<List<ApiServiceCat>>() {
            @Override
            public void onResponse(Call<List<ApiServiceCat>> call, Response<List<ApiServiceCat>> response) {
                dialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ApiServiceCat>> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MenuActivity.this, "Tau Ah...Coba Lagi Dong!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateDataList(List<ApiServiceCat> body) {
        listCat = findViewById(R.id.listData);
        adapter = new CatAdapter(this, body);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuActivity.this);
        listCat.setLayoutManager(layoutManager);
        listCat.setAdapter(adapter);
    }
}
