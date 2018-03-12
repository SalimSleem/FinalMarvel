package com.example.pierreabichacra.tester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    ArrayList<Hero> heroes = new ArrayList<Hero>();
    private static final String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Osas el recyclerview

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroAdapter heroAdapter = new HeroAdapter(getApplicationContext(), heroes);
        recyclerView.setAdapter(heroAdapter);


        ApiManager api = new ApiManager();
        Call result = api.api();
        result.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                return;
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();

                try {

                    JSONObject object = new JSONObject(res);
                    JSONObject jb1 =object.getJSONObject("data");
                    JSONArray array = jb1.getJSONArray("results");

                        for (int b =0; b< array.length(); b++)
                    {
                        String compact = array.get(b).toString();
                        Log.i(TAG, compact);
                        JSONObject heroI = new JSONObject(compact);
                        String thumbnail = heroI.getString("thumbnail");
                        JSONObject src = new JSONObject(thumbnail);
                        Log.i(TAG, src.getString("path")+"."+src.getString("extension"));
                        Hero a = new Hero(heroI.getString("name"), src.getString("path"+"."+src.getString("extension")));
                        Log.i(TAG, "Name: "+heroI.getString("name"));
                        Log.i(TAG, "ImagePath"+ src.getString("path"+"."+src.getString("extension")));
                        heroes.add(a);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
