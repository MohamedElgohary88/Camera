package com.example.camera

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    lateinit var VideoView:VideoView
    lateinit var btnVideo:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initliaz()

    btnVideo.setOnClickListener { callvideo() }

    VideoView.setOnCompletionListener {
    VideoView.visibility = View.GONE
    btnVideo.visibility = View.VISIBLE}
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK && data!=null){
            VideoView.setVideoURI(data.data)
            btnVideo.visibility = View.GONE
            VideoView.visibility = View.VISIBLE
            VideoView.start()
         }else{
             Toast.makeText(this,"Proplem",Toast.LENGTH_SHORT).show()
         }
    }
    fun initliaz(){
        VideoView = findViewById(R.id.VideoView)
        btnVideo = findViewById(R.id.btnVideo)
    }
    fun callvideo(){
        val videointent =Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        startActivityForResult(videointent,1)
    }
}