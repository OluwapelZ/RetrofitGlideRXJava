package com.example.oluwapelumiolaoye.glidemvpretrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.oluwapelumiolaoye.glidemvpretrofit.R;
import com.example.oluwapelumiolaoye.glidemvpretrofit.apiservice.DogService;
import com.example.oluwapelumiolaoye.glidemvpretrofit.apiutilities.ApiUtils;
import com.example.oluwapelumiolaoye.glidemvpretrofit.model.Dog;
import com.jackandphantom.circularimageview.CircleImage;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogActivity extends AppCompatActivity {

    private DogService dogService;
    private CircleImage dogImage;
    private Button reload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dogService = ApiUtils.getDogService();
        dogImage = (CircleImage) findViewById(R.id.dog_image);
        reload = (Button) findViewById(R.id.reload);
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage();
            }
        });
    }



    //Method to load the image url
    public void loadImage() {
        dogService.getDog().enqueue(new Callback<Dog>() {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response) {
                if(response.body() != null) {
                    if(response.body().getStatus().equals("success")) {
                        useGlide(response.body().getMessageUrl());
                    }
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<Dog> call, Throwable t) {
                Toast.makeText(getApplication(), "Error loading from API", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Load with glide
    public void useGlide(String imageUri){
        Glide.with(getApplicationContext())
                .load(imageUri)
                .bitmapTransform(new CropCircleTransformation(this))
                .centerCrop()
                .into(dogImage);
    }


}
