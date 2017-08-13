package thesis.eng.reviewer.service;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import library.jdp.jdppatternkotlin.BuildConfig;
import library.jdp.jdppatternkotlin.service.RetrofitContract;
import library.jdp.jdppatternkotlin.service.RetrofitHeaderInterceptor;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jamesdeperio on 7/16/2017.
 */

public abstract class RetrofitService implements RetrofitContract {
    protected abstract void initHeader();
    private Retrofit retrofit;
    private RetrofitHeaderInterceptor retrofitHeaderInterceptor= new RetrofitHeaderInterceptor();
    private Retrofit getRetrofit() {
        return retrofit;
    }
    public Object initialize(Context context, Class service) {
        int cacheSize = setCacheSize() * 1024 * 1024;
        OkHttpClient okHttpClient;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            okHttpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .writeTimeout(initWriteTimeout(), TimeUnit.SECONDS)
                    .connectTimeout(initConnectTimeout(), TimeUnit.SECONDS)
                    .readTimeout(initReadTimeout(), TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .addInterceptor(retrofitHeaderInterceptor)
                    .build();
        }else {
            okHttpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .writeTimeout(initWriteTimeout(), TimeUnit.SECONDS)
                    .connectTimeout(initConnectTimeout(), TimeUnit.SECONDS)
                    .readTimeout(initReadTimeout(), TimeUnit.SECONDS)
                    .addInterceptor(retrofitHeaderInterceptor)
                    .build();
        }

        retrofit = new Retrofit.Builder()
                .baseUrl(setBaseURL())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return getRetrofit().create(service);
    }

    public long initWriteTimeout() {
        return 10;
    }

    public long initConnectTimeout() {
        return 10;
    }

    public long initReadTimeout() {
        return 30;
    }

    public void addHeader(@NonNull String key, @NonNull String value){
        retrofitHeaderInterceptor.addHeader(key,value);
    }
}
