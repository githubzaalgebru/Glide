package com.algebra.glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate( savedInstanceState : Bundle? ) {

        val photos = PhotoProvider( )

        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        bGenerate.setOnClickListener {
            val url = photos.randomImage( )
            Glide.with( this )
                .load( url )
                .into( imageView )
        }
    }
}