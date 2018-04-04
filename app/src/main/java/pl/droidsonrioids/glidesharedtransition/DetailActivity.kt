package pl.droidsonrioids.glidesharedtransition

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val url = intent.getStringExtra(IMAGE_URL_KEY)
        detailImage.transitionName = url
        detailImage.load(url)
    }
}
