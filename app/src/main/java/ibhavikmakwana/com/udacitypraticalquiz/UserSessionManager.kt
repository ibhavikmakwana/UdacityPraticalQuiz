package ibhavikmakwana.com.udacitypraticalquiz

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Bhavik Makwana on 7/31/2017.
 */

class UserSessionManager(context: Context) {
    private val mSharedPreference: SharedPreferences

    val userName: String?
        get() = getStringFromPreferences(USER_NAME)

    val email: String?
        get() = getStringFromPreferences(EMAIL)

    val about: String?
        get() = getStringFromPreferences(ABOUT)

    init {
        mSharedPreference = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
    }

    fun setNewSession(userName: String,
                      email: String,
                      about: String) {
        //save data to the share prefs.
        savePreferences(USER_NAME, userName)
        savePreferences(EMAIL, email)
        savePreferences(ABOUT, about)
    }

    private fun savePreferences(key: String, value: String?) {
        //Save to share prefs
        val prefsEditor = mSharedPreference.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    private fun getStringFromPreferences(key: String): String? {
        return mSharedPreference.getString(key, null)
    }

    companion object {

        //user preferences keys
        private const val USER_NAME = "USER_NAME"
        private const val EMAIL = "EMAIL"
        private const val ABOUT = "ABOUT"
        private const val PREF_FILE = "app_prefs"
    }
}