package id.co.fundtastic.client.network

import android.os.Build
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


fun networkClient() = Retrofit.Builder()
    .baseUrl("https://services1.arcgis.com/0MSEUqKaxRlEPj5g/arcgis/rest/services/ncov_cases/FeatureServer/1/")
    .client(httpClient())
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()


private fun httpClient(): OkHttpClient {

    val clientBuilder = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(NetworkInterceptor())

    val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    clientBuilder.addInterceptor(httpLoggingInterceptor)
    return clientBuilder.build()

}


class NetworkInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        val requestWithUserAgent = originRequest.newBuilder()
            .header("X-FUNDtastic-Appkey", "48336898ba2eda79c859d7508366e553")
            .header("User-Agent", "FUNDtastic-Android")
            .header("X-device-type", Build.DEVICE)
            .header("X-version-os", versionOS())
            .build()
        return chain.proceed(requestWithUserAgent)
    }

    private fun versionOS(): String {
        when (Build.VERSION.SDK_INT) {
            16 -> return "Jelly Bean"
            17 -> return "Jelly Bean MR1"
            18 -> return "Jelly Bean MR2"
            19 -> return "Kitkat"
            20 -> return "Kitkat Watch"
            21 -> return "Lollipop"
            22 -> return "Lollipop MR1"
            23 -> return "Mashmallow"
            24 -> return "Nougat"
            25 -> return "Nougat MR1"
            26 -> return "Oreo"
            27 -> return "Oreo MR1"
            28 -> return "Pie"
            else -> return "Q"
        }
    }

}
