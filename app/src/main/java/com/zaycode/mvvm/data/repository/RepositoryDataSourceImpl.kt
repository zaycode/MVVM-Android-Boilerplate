package com.zaycode.mvvm.data.repository

import com.zaycode.mvvm.data.cache.CacheRemoteDataSource
import com.zaycode.mvvm.data.remote.RemoteDataSource

class RepositoryDataSourceImpl (val remoteDataSource:RemoteDataSource,val cacheDataSource:CacheRemoteDataSource) : RepositoryDataSource {

}