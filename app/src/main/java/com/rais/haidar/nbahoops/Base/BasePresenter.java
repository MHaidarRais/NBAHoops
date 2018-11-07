package com.rais.haidar.nbahoops.Base;

public interface BasePresenter<T extends BaseView> {

    void onAttach(T v);
    void onDetach();

}
