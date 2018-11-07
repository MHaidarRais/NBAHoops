package com.rais.haidar.nbahoops.Main.Presenter;

import com.rais.haidar.nbahoops.Base.BasePresenter;
import com.rais.haidar.nbahoops.Main.View.MainView;
import com.rais.haidar.nbahoops.Main.model.ArticlesItem;
import com.rais.haidar.nbahoops.Main.model.ResponseNBA;
import com.rais.haidar.nbahoops.Network.configNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {
    MainView mainView;
    private String apikey = "5h30dB4K4Uwuhj4KkmHmFkrBzQHtf2wGPVQSARoCa+HgMHZRk0/vFn0ZKpFDgc1KYy/F7LEE8nAOHhKgru6btQ==";

    public Call<ResponseNBA> call() {
        return configNetwork.getInstance().getNBA();
    }

    public void getData(){
        call().enqueue(new Callback<ResponseNBA>() {
            @Override
            public void onResponse(Call<ResponseNBA> call, Response<ResponseNBA> response) {
                if (response.body().getStatus().equalsIgnoreCase("ok")){
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSuccess(articlesItems);
                }else {
                    mainView.onError("GAGAL mengambil data");
                }
            }

            @Override
            public void onFailure(Call<ResponseNBA> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }
}

