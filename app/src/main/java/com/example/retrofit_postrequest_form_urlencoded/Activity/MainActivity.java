package com.example.retrofit_postrequest_form_urlencoded.Activity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit_postrequest_form_urlencoded.Adapter.UserAdapter;
import com.example.retrofit_postrequest_form_urlencoded.Interface.ApiInterface;
import com.example.retrofit_postrequest_form_urlencoded.Model.Model;
import com.example.retrofit_postrequest_form_urlencoded.R;
import com.example.retrofit_postrequest_form_urlencoded.Retrofit.ApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<Model> models;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getData();
        postData();
    }

    private void getData() {
        apiInterface = ApiClient.getInstance().getApi();
        Call<List<Model>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                models = response.body();
                userAdapter = new UserAdapter(models);
                recyclerView.setAdapter(userAdapter);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void postData() {
        //Using Simple @Post

        //Call<ResponseBody> call = apiInterface.createPost(new Model(1,"This is title","This is body"));

        // Using UrlEncoded @post

        //Call<Model> call = apiInterface.createPost(1,"This is title","This is body");

        //Using UrlEncoded HasMap

        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "25");
        fields.put("title", "This is title");
        fields.put("body", "This is body");
        Call<Model> call = apiInterface.createPost(fields);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });

    }

    private void init() {
        recyclerView = findViewById(R.id.userRecyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        models = new ArrayList<>();


    }
}
