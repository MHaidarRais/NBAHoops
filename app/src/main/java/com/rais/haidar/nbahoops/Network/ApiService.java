package com.rais.haidar.nbahoops.Network;

import com.rais.haidar.nbahoops.Main.model.ResponseNBA;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("everything?q=NBA&from=2018-11-07&to=2010-11-04&pagesize=100&domains=hypebeast.com&apiKey=742f9c39ed6c4d5c8874aadb10b34b79")
    Call<ResponseNBA> getNBA(
    );
}
