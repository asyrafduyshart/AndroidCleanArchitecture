package com.asyraf.cleanlist.data.base;

import com.asyraf.cleanlist.core.errors.InvalidSessionError;
import com.asyraf.cleanlist.core.errors.NetworkUnavailableError;
import com.asyraf.cleanlist.core.errors.ServerError;
import com.asyraf.cleanlist.core.errors.UnsupportedVersionError;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

public class NetworkErrorHandler implements ErrorHandler {
    @Override
    public Throwable handleError(RetrofitError error) {
        if (error.getKind() == RetrofitError.Kind.NETWORK) {
            return new NetworkUnavailableError();
        } else if (error.getKind() == RetrofitError.Kind.HTTP) {
            int statusCode = error.getResponse().getStatus();
            if (statusCode == 401 || statusCode == 403) {
                return new InvalidSessionError();
            } else if (statusCode == 410) {
                return new UnsupportedVersionError();
            } else {
                try {
                    return (ServerError) error.getBodyAs(ServerError.class);
                }  catch (Exception e) {}
            }
        }
        return error;
    }
}