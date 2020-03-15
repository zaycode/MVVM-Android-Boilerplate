package com.zaycode.mvvm.network

import retrofit2.HttpException

object ErrorMessageUtility {

    private const val DEFAULT_ERROR_MESSAGE  = "Koneksi Internet Bermasalah!"

    private const val STATUS_SERVER_ERROR_MESSAGE = "Tidak bisa terhubung ke server"
    private val STATUS_UNAUTHORIZED = 401
    private val STATUS_NOT_FOUND = 404
    private val STATUS_BAD_REQUEST = 400
    private val STATUS_FORBIDDEN = 403
    private val STATUS_SERVER_ERROR = 500
    private val STATUS_NOT_IMPLEMENTED = 501
    private val STATUS_BAD_GATEWAY = 502
    private val STATUS_SERVICE_UNAVAILABLE = 503

    fun generateMessage(throwable: Throwable): String {
        return  when (throwable) {
            is HttpException -> {
                when (throwable.code()) {
                    STATUS_SERVER_ERROR -> STATUS_SERVER_ERROR_MESSAGE
                    STATUS_UNAUTHORIZED ->{
                        return "Auth Not Found"
                    }
                    else -> DEFAULT_ERROR_MESSAGE
                }
            }
            else -> DEFAULT_ERROR_MESSAGE
        }
    }
}