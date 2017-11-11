package com.example.oluwapelumiolaoye.glidemvpretrofit.retrofitbuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oluwapelumi.olaoye on 11/11/17.
 */

public class RetrofitClient {

    public static Retrofit retrofit = null;

    public static Retrofit getClient(String base_url){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
