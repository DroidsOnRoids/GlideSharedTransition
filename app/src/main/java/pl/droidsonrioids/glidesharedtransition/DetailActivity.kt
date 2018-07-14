package pl.droidsonrioids.glidesharedtransition

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import androidx.core.transition.doOnEnd
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private val url by lazy {
        intent.getStringExtra(IMAGE_URL_KEY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportPostponeEnterTransition()
        detailImage.transitionName = url
        detailImage.load(url, true) {
            supportStartPostponedEnterTransition()
        }
        window.sharedElementEnterTransition = TransitionSet()
                .addTransition(ChangeImageTransform())
                .addTransition(ChangeBounds())
                .apply {
                    doOnEnd { detailImage.load(url) }
                }
        window.enterTransition = Fade().apply {
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
            excludeTarget(R.id.action_bar_container, true)
        }
    }
}
