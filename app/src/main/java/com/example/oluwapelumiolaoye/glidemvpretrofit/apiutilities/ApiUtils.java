package com.example.oluwapelumiolaoye.glidemvpretrofit.apiutilities;

import com.example.oluwapelumiolaoye.glidemvpretrofit.apiservice.DogService;
import com.example.oluwapelumiolaoye.glidemvpretrofit.retrofitbuilder.RetrofitClient;

/**
 * Created by oluwapelumi.olaoye on 11/11/17.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://dog.ceo";

    public static DogService getDogService() {
        return RetrofitClient.getClient(BASE_URL).create(DogService.class);
    }
}
