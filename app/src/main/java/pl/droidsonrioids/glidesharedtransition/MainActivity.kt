package pl.droidsonrioids.glidesharedtransition

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        images.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = ImageAdapter(photos())
        }
    }

    private fun photos() = (169..216)
            .map { "https://picsum.photos/1000/700?image=$it" }
}