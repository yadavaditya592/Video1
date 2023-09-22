package com.example.video1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoUrl="https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"

        videoView=findViewById(R.id.videoView)
        val mediaController=MediaController(this)
        mediaController.setAnchorView(videoView)

        videoView.setVideoURI(Uri.parse(videoUrl))
        videoView.setMediaController(mediaController)
        videoView.requestFocus()

        videoView.start()
        videoView.setOnCompletionListener {
            Toast.makeText(this, "video is completed", Toast.LENGTH_SHORT).show()
        }
        videoView.setOnInfoListener { mp, what, extra ->
            Toast.makeText(this, "No network", Toast.LENGTH_SHORT).show()
            true
        }
        }
}