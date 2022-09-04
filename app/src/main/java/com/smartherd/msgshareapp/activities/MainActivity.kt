package com.smartherd.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareapp.Constants
import com.smartherd.msgshareapp.databinding.ActivityMainBinding
import com.smartherd.msgshareapp.showToast

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            Log.i(TAG, "Button Was Clicked !")
            showToast("Button Was Clicked !")
        }

        binding.btnSendMessageToNextActivity.setOnClickListener {
            val message: String = binding.etUserMessage.text.toString()
            showToast(message)
            val intent = Intent(this, SecondActivity::class.java).also {
                it.putExtra(Constants.USER_MSG_KEY, message)
                startActivity(it)
            }
        }

        binding.btnShareToOtherApps.setOnClickListener {
            val message: String = binding.etUserMessage.text.toString()
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, message)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(intent, "Share To :"))
        }

        binding.btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java).also {
                startActivity(it)
            }
        }
    }


}