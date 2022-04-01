package com.algebra.glide

import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate( savedInstanceState : Bundle? ) {

        val photos = PhotoProvider( )

        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        bGenerate.setOnClickListener {
            val url = photos.randomImage( )
            Log.i( TAG, "URL: $url" )
            Glide.with( this )
                .load( url )
                .centerCrop( )
                .error( R.drawable.ic_broken_image )
                .fallback( R.drawable.ic_no_image )
                .into( imageView )
        }



        bCircle.setOnClickListener {
            val url = photos.randomImage( )
            Log.i( TAG, "URL: $url" )
            Glide.with( this )
                .load( url )
                .placeholder( R.drawable.ic_image_place_holder )
                .error( R.drawable.ic_broken_image )
                .transform( CircleCrop( ) )
                .into( imageView )
        }



        bTransform.setOnClickListener {
            val url = photos.randomImage( )
            Log.i( TAG, "URL: $url" )
            Glide.with( this )
                .load( url )
                .override( 500, 500 )
                .transform(
                    CenterCrop( ),
                    BlurTransformation( 5 ),
                    ContrastFilterTransformation( 2.0f ),
                    VignetteFilterTransformation(
                        PointF( 0.5f, 0.5f),
                        floatArrayOf( 0f, 0f, 0f ),
                        0f,
                        0.4f
                    )
                )
                .into( imageView )
        }
    }
}