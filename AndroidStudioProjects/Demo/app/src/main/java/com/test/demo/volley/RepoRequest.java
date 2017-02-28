package com.test.demo.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.demo.retrofit.Repo;

import java.util.List;

/**
 * Created by lizhi
 * 17-2-28
 */
public class RepoRequest extends Request<List<Repo>> {

    private RequestWatcher mWatcher;

    public RepoRequest(String url, RequestWatcher listener) {
        super(url, listener);
        mWatcher = listener;
    }

    public RepoRequest(int method, String url, RequestWatcher listener) {
        super(method, url, listener);
        mWatcher = listener;
    }

    @Override
    protected Response<List<Repo>> parseNetworkResponse(NetworkResponse response) {
        String jsonStr = new String(response.data);
        Gson gson = new Gson();
        TypeToken<List<Repo>> repoTypeToken = new TypeToken<List<Repo>>(){};
        List<Repo> list = gson.fromJson(jsonStr, repoTypeToken.getType());
        return Response.success(list, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(List<Repo> responses) {
        mWatcher.onSuccess(responses);
    }

    @Override
    public void deliverError(VolleyError error) {
        mWatcher.onErrorResponse(error);
    }
}
