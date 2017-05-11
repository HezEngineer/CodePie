package com.hezhi.kiss.http.okhttp.request;

import android.support.annotation.Nullable;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by yf11 on 2017/4/26.
 */

public class CommonRequest {

    public static final String BOUNDARY = "--5201314";
    public static final MediaType FILE_TYPE = MediaType.parse("application/octet-stream");

    /**
     * 创建get请求
     * @param tag
     * @param url
     * @param requestParams
     * @return
     */
    public static Request createGetRequest(String tag,String url, RequestParam requestParams) {
        return createGetRequest(tag,url,requestParams,null);
    }

    /**
     * 创建带请求头的get请求
     * @param tag
     * @param url
     * @param requestParams
     * @param headerParams
     * @return
     */
    private static Request createGetRequest(String tag,String url, @Nullable RequestParam requestParams, @Nullable RequestParam headerParams) {
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if(requestParams != null) {
            for (Map.Entry<String,String> entry : requestParams.getParams().entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }

        if (headerParams != null) {
            Headers.Builder headerBuilder = new Headers.Builder();
            for (Map.Entry<String, String> entry : headerParams.getParams().entrySet()) {
                headerBuilder.add(entry.getKey(),entry.getValue());
            }
            return new Request.Builder()
                    .url(urlBuilder.substring(0,urlBuilder.length()-1))
                    .get()
                    .headers(headerBuilder.build())
                    .build();
        }

        return new Request.Builder()
                .url(urlBuilder.substring(0,urlBuilder.length()-1))
                .get()
                .tag(tag)
                .build();
    }

    /**
     * 创建Post请求
     *
     * @param tag
     * @param url
     * @param requestParams
     * @return
     */
    public static Request createPostRequest(String tag, String url, @Nullable RequestParam requestParams) {
        return createPostRequest(tag,url,requestParams,null);
    }

    /**
     * 创建带请求头的Post请求
     * @param tag
     * @param url
     * @param requestParams
     * @param headerParams
     * @return
     */
    private static Request createPostRequest(String tag,String url, @Nullable RequestParam requestParams, @Nullable RequestParam headerParams) {
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if (requestParams !=null) {
            for (Map.Entry<String, String> entry : requestParams.getParams().entrySet()) {
                    bodyBuilder.add(entry.getKey(),entry.getValue());
            }
        }
        //添加请求头
        if (headerParams != null) {
            Headers.Builder headerBuilder = new Headers.Builder();
            for (Map.Entry<String, String> entry : headerParams.getParams().entrySet()) {
                headerBuilder.add(entry.getKey(),entry.getValue());
            }
            return new Request.Builder()
                    .url(url)
                    .post(bodyBuilder.build())
                    .headers(headerBuilder.build())
                    .build();
        }

        return new Request.Builder()
                .url(url)
                .post(bodyBuilder.build())
                .tag(tag)
                .build();

    }

    public static Request createUploadRequest(String tag,String url,RequesFileParam param) {
        MultipartBody.Builder requestBody = new MultipartBody.Builder(BOUNDARY);
        requestBody.setType(MultipartBody.FORM);
        if(param !=null) {
            for (Map.Entry<String, Object>  entry: param.getFileParams().entrySet()) {
                if(entry.getValue() instanceof File) {
                    requestBody.addPart(Headers.of("Content-Disposition","form-data; name=\""+entry.getKey()+"\""),
                            RequestBody.create(FILE_TYPE,(File) entry.getValue()));
                } else {
                    requestBody.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(null, (String) entry.getValue()));
                }
                
            }
        }
        return new Request.Builder().url(url).tag(tag).post(requestBody.build()).build();


    }

}
