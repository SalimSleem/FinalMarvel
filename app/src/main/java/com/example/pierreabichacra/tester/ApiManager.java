package com.example.pierreabichacra.tester;

import okhttp3.*;

/**
 * Created by Pierre Abi Chacra on 3/12/2018.
 */

public class ApiManager {

    public Call api(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://gateway.marvel.com/v1/public/characters?apikey=ce84cd0f696ef1be780895bc2eaf3725&hash=c31b52717ce00c58070bc2986f60aad6&ts=1520589864")
                .build();
        return client.newCall(request);
    }
}
