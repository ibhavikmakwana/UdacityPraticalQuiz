package ibhavikmakwana.com.udacitypraticalquiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class DetailsActivity : AppCompatActivity() {

    /**
     * Call this method to launch the activity.
     */
    companion object {
        const val USER_NAME = "USER_NAME"
        const val EMAIL = "EMAIL"
        const val ABOUT = "ABOUT"
        fun launchActivity(context: Context) {
            val intent = Intent(context, DetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val userSessionManager = UserSessionManager(this)

        if (userSessionManager.userName != null &&
                userSessionManager.email != null &&
                userSessionManager.about != null) {

            tv_name.text = userSessionManager.userName
            tv_email.text = userSessionManager.email
            tv_about.text = userSessionManager.about
        }
    }
}