package icu.shisheng.open2share

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class ReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        sendIntent.addCategory("android.intent.category.DEFAULT")

        Log.d("Share","Data:"+ intent.data.toString());
        //Log.d
        Log.d("Share","Type:"+ intent.type);

        sendIntent.putExtra(Intent.EXTRA_STREAM, intent.data)
        sendIntent.type = intent.type
        this.startActivityForResult(Intent.createChooser(sendIntent, getString(R.string.share_title)), 1)
    }
    override fun onDestroy() {
        super.onDestroy()
        this.finishAffinity()
    }

}
