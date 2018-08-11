package com.planetinnovative.api_integration;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.planetinnovative.api_integration.Moview.MovieResponse;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import okhttp3.internal.connection.RealConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button click = findViewById(R.id.click);
        Button click2 = findViewById(R.id.click2);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BASE_URL = "https://api.themoviedb.org/3/movie/";

                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build();

                MovieService service = retrofit.create(MovieService.class);
                service.getMovie().enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        System.out.println("WORKING");
                        Realm.init(getApplicationContext());
                        RealmConfiguration config =new  RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
                        Realm realm = Realm.getInstance(config);
                        realm.beginTransaction();
                        realm.copyToRealm(response.body());
                        realm.commitTransaction();
                        realm.close();
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                        System.out.println(t.getMessage());
                    }
                });
            }
        });

        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm.init(getApplicationContext());
                RealmConfiguration config =new  RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
                Realm realm = Realm.getInstance(config);
                RealmResults<MovieResponse> res = realm.where(MovieResponse.class).findAll();
                System.out.println(res.size());
                System.out.println(res.get(0).getTitle());
            }
        });
    }
}
