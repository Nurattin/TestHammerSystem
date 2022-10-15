package com.example.testhammersystem.data.di

import com.example.testhammersystem.data.FoodsDataRepositoryIml
import com.example.testhammersystem.domain.reposiroty.FoodsDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun binFoodsDateRepository(repo: FoodsDataRepositoryIml): FoodsDataRepository
}