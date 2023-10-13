package com.anafthdev.camerax

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {

    private val _bitmaps = MutableStateFlow(emptyList<Bitmap>())
    val bitmaps: StateFlow<List<Bitmap>> = _bitmaps

    fun addBitmap(bitmap: Bitmap) {
        _bitmaps.value += bitmap
    }

}