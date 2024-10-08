package com.github.weslleystos.feature.home.productdetail

import androidx.lifecycle.ViewModel
import com.github.weslleystos.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    navigator: Navigator
) : ViewModel(), Navigator by navigator
