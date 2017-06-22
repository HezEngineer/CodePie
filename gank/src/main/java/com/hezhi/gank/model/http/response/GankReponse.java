package com.hezhi.gank.model.http.response;

/**
 * Created by yf11 on 2017/6/16.
 */

public class GankReponse <T> {
    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
