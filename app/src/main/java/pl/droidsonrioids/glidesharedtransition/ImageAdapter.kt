package pl.droidsonrioids.glidesharedtransition

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ImageAdapter(private val images: List<String>, private val onClick: (String, View) -> Unit) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) = holder.bind(images[position])

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(url: String) {
            (itemView as ImageView).apply {
                load(url)
                transitionName = url
                setOnClickListener { onClick(url, it) }
            }
        }
    }

}