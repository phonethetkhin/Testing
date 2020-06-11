package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vModel = ViewModelProviders.of(this).get(ServerSettingViewModel::class.java)

        btnCheck.setOnClickListener {

            val serverSetting = vModel.getServerSetting(1)[1].setting_id
txtSize.setText(serverSetting.toString())
        }

        btnSave.setOnClickListener {

            vModel.insertServerSetting(initializeServerEntity(0,0,"192.168.1.226","fams-api",1))

        }
        btnDelete.setOnClickListener {
            vModel.deleteAllServerSetting()

        }
    }
}
