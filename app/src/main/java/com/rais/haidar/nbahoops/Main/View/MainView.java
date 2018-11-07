package com.rais.haidar.nbahoops.Main.View;

import com.rais.haidar.nbahoops.Base.BaseView;
import com.rais.haidar.nbahoops.Main.model.ArticlesItem;

import java.util.List;

public interface MainView extends BaseView {

    void onSuccess(List<ArticlesItem> data);
    void onError(String msg);

}
