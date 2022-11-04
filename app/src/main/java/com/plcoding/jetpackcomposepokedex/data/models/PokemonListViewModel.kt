package com.plcoding.jetpackcomposepokedex.data.models

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.plcoding.jetpackcomposepokedex.repository.PokemonRepository
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    fun dominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {

        // convert bitmap so we can use it
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true) //

        // Gives a color palette than we can use
        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}