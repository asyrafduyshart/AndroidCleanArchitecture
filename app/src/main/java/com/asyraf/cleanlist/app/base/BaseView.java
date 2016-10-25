package com.asyraf.cleanlist.app.base;

public interface BaseView {
    void handleGlobalError(Throwable e);

    void hideKeyboard();

    void showProgressDialog(String message);

    void hideProgressDialog();
}
