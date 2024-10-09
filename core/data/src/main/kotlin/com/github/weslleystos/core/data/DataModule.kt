package com.github.weslleystos.core.data

import com.github.weslleystos.core.data.products.ProductRepository
import com.github.weslleystos.core.data.products.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun bindProductRepository(repository: ProductRepositoryImpl): ProductRepository
}
