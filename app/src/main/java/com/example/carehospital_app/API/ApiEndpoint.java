package com.example.carehospital_app.API;

import com.example.carehospital_app.Model.HospitalResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("data_rumahsakit.php")
    Call<HospitalResponseModel> data_rumahSakit();
}
