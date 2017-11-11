package com.example.oluwapelumiolaoye.glidemvpretrofit.apiservice;

import com.example.oluwapelumiolaoye.glidemvpretrofit.model.Dog;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by oluwapelumi.olaoye on 11/11/17.
 */

public interface DogService {

    @GET("/api/breeds/image/random")
    Call<Dog> getDog();

}
