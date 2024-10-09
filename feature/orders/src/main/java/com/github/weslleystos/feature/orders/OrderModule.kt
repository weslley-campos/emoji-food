package com.github.weslleystos.feature.orders

import com.github.weslleystos.feature.orders.repositories.OrderRepository
import com.github.weslleystos.feature.orders.repositories.OrderRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class OrderModule {

    @Singleton
    @Binds
    abstract fun bindProductRepository(repository: OrderRepositoryImpl): OrderRepository
}
