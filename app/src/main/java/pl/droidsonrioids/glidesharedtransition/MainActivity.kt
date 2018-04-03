package pl.droidsonrioids.glidesharedtransition

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

val IMAGE_URL_KEY = "url"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        images.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = ImageAdapter(photos(), ::goToDetails)
        }
    }

    fun goToDetails(url: String) {
        Intent(this, DetailActivity::class.java)
                .putExtra(IMAGE_URL_KEY, url)
                .let {
                    startActivity(it)
                }
    }

    private fun photos() = (169..216)
            .map { "https://picsum.photos/1000/700?image=$it" }
}