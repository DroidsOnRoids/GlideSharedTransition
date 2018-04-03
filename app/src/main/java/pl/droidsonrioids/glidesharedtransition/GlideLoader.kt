package pl.droidsonrioids.glidesharedtransition

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.load(url: String) {
    Glide.with(this)
            .load(url)
            .apply(RequestOptions.placeholderOf(R.drawable.placeholder))
            .into(this)
}