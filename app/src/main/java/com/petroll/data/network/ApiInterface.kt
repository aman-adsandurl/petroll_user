package com.petroll.data.network

import com.google.gson.GsonBuilder
import com.petroll.BuildConfig
import com.petroll.data.pref.SharedPref
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

interface ApiInterface {

    companion object {

        @Volatile
        private var INSTANCE: ApiInterface? = null

        @Volatile
        private var INSTANCE_WITHOUT_AUTH_TOKEN: ApiInterface? = null

        @Volatile
        private var INSTANCE_WITHOUT_ENCRYPT: ApiInterface? = null

        fun getInstance(): ApiInterface {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: create(true).also {
                    INSTANCE = it
                }
            }
        }

        fun getInstanceWithoutAuthToken(): ApiInterface {
            return INSTANCE_WITHOUT_AUTH_TOKEN ?: synchronized(this) {
                INSTANCE_WITHOUT_AUTH_TOKEN ?: create(
                    needEncrypt = true,
                    needAuthToken = false
                ).also {
                    INSTANCE_WITHOUT_AUTH_TOKEN = it
                }
            }
        }

        fun resetInstance(): ApiInterface {
            INSTANCE = null
            return getInstance()
        }

        fun getWithoutEncryptInstance(): ApiInterface {
            return INSTANCE_WITHOUT_ENCRYPT ?: synchronized(this) {
                INSTANCE_WITHOUT_ENCRYPT ?: create(
                    false,
                    needDecryptResponse = true
                ).also { INSTANCE_WITHOUT_ENCRYPT = it }
            }
        }

        private fun create(
            needEncrypt: Boolean,
            needDecryptResponse: Boolean = false,
            needAuthToken: Boolean = true
        ): ApiInterface {

            val httpClient = OkHttpClient.Builder()
            httpClient.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            httpClient.readTimeout(TIME_OUT, TimeUnit.SECONDS)
            httpClient.writeTimeout(TIME_OUT, TimeUnit.SECONDS)

//            if (needEncrypt) {
//                httpClient.addInterceptor(EncryptionInterceptor())
//                httpClient.addInterceptor(DecryptionInterceptor())
//            }
//
//            if (needDecryptResponse) {
//                httpClient.addInterceptor(DecryptionInterceptor())
//            }

            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .method(original.method, original.body)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("X-localization", Locale.getDefault().language)
                    .header(
                        "Authorization",
                        "Bearer ${if (needAuthToken) SharedPref.authToken else ""}"
                    )
                chain.proceed(requestBuilder.build())
            }

            if (BuildConfig.DEBUG) {
                val logging =
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                httpClient.addInterceptor(logging)
            }

            return Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(httpClient.build())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().setLenient().create()
                    )
                )
                .addConverterFactory(ScalarsConverterFactory.create())
                .build().create(ApiInterface::class.java)
        }

    }
}