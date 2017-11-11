package com.example.oluwapelumiolaoye.glidemvpretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oluwapelumi.olaoye on 11/11/17.
 */

public class Dog {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String messageUrl;

    public String getStatus() {
        return status;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "status='" + status + '\'' +
                ", messageUrl='" + messageUrl + '\'' +
                '}';
    }
}
