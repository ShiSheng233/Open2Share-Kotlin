package icu.shisheng.open2share


import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.settings, SettingsFragment())
                    .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat(), Preference.OnPreferenceClickListener {
        var guidePreference: Preference? = null
        var aboutPreference: Preference? = null

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

            guidePreference = findPreference("guide")
            guidePreference!!.setOnPreferenceClickListener(this)
            aboutPreference = findPreference("about")
            aboutPreference!!.setOnPreferenceClickListener(this)
        }

        override fun onPreferenceClick(preference: Preference): Boolean {
            if (preference === guidePreference) {
                val intent = Intent(activity, GuideActivity::class.java)
                startActivity(intent)
                return true
            }
            else if (preference === aboutPreference) {
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.about_dial_tit)
                    .setMessage(R.string.about_dial_msg)
                    .setPositiveButton(R.string.ok, null)
                    .setNeutralButton(R.string.website) { dialog, which ->
                        val intent = Intent()
                        intent.action = "android.intent.action.VIEW"
                        val content_url: Uri = Uri.parse("https://shisheng.icu")
                        intent.data = content_url
                        startActivity(intent)
                    }
                    .create()
                    .show()
            }
            return false
        }

    }
}