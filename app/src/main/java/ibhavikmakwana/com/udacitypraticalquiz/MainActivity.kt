package ibhavikmakwana.com.udacitypraticalquiz

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var userSessionManager: UserSessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cv_top_left.circleColor = ContextCompat.getColor(this, R.color.colorCircleOne)
        cv_bottom_left.circleColor = ContextCompat.getColor(this, R.color.colorCircleTwo)
        cv_bottom_right.circleColor = ContextCompat.getColor(this, R.color.colorCircleThree)
        cv_top_right.circleColor = ContextCompat.getColor(this, R.color.colorCircleOne)

        userSessionManager = UserSessionManager(this)
        init()

        if (savedInstanceState != null) {
            edt_user_name.setText(savedInstanceState.getString(DetailsActivity.USER_NAME))
            edt_email.setText(savedInstanceState.getString(DetailsActivity.EMAIL))
            edt_about.setText(savedInstanceState.getString(DetailsActivity.ABOUT))
        }

        btn_next.setOnClickListener {
            DetailsActivity.launchActivity(this)
            val userName = edt_user_name.text
            val email = edt_email.text
            val about = edt_about.text
            UserSessionManager(this).setNewSession(userName.toString(), email.toString(), about.toString())
            finish()
        }
    }

    private fun init() {
        if (userSessionManager.userName != null &&
                userSessionManager.email != null &&
                userSessionManager.about != null) {
            DetailsActivity.launchActivity(this)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putString(DetailsActivity.USER_NAME, edt_user_name.text.toString())
        outState?.putString(DetailsActivity.EMAIL, edt_email.text.toString())
        outState?.putString(DetailsActivity.ABOUT, edt_about.text.toString())
    }
}
