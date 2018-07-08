package com.loften.baselibrary.data.net;

import com.loften.baselibrary.BaseConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static RetrofitFactory instance;
    private Retrofit retrofit;
    private Interceptor interceptor;

    private RetrofitFactory(){
        interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("charset", "utf-8")
                        .build();
                return chain.proceed(request);
            }
        };

        retrofit = new Retrofit.Builder()
                .baseUrl(BaseConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build();

    }

    public static RetrofitFactory getInstance(){
        if(instance == null){
            synchronized (RetrofitFactory.class){
                if(instance == null){
                    instance = new RetrofitFactory();
                }
            }
        }
        return instance;
    }

    private OkHttpClient initClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(initLogInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        return client;
    }

    //日志拦截器
    private Interceptor initLogInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    public  <T> T create(Class<T> service){
        return retrofit.create(service);
    }
}
