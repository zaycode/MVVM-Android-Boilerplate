package com.zaycode.mvvm.di

import com.zaycode.mvvm.data.UseCase
import com.zaycode.mvvm.MVVMViewModel
import com.zaycode.mvvm.data.cache.CacheRemoteDataSource
import com.zaycode.mvvm.data.cache.CacheRemoteDataSourceImpl
import com.zaycode.mvvm.data.remote.Remote
import com.zaycode.mvvm.data.remote.RemoteDataSource
import com.zaycode.mvvm.data.remote.RemoteDataSourceImpl
import com.zaycode.mvvm.data.repository.RepositoryDataSource
import com.zaycode.mvvm.data.repository.RepositoryDataSourceImpl
import id.co.fundtastic.client.network.networkClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { MVVMViewModel(get()) }
}


val useCaseModule = module {
    factory { UseCase(repository = get()) }
}

val repositoryModule = module {
    single {
        RepositoryDataSourceImpl(
            remoteDataSource = get(),
            cacheDataSource = get()
        ) as RepositoryDataSource
    }
}

val dataSourceModule = module {
    single { RemoteDataSourceImpl(remote = get()) as RemoteDataSource }
    single { CacheRemoteDataSourceImpl(preferencesHelper = get()) as CacheRemoteDataSource }
}

val networkModule = module {
    single { api }
}

private val retrofit = networkClient()

private val api: Remote = retrofit.create(Remote::class.java)
