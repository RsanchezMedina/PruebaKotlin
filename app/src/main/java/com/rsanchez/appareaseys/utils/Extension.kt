package com.rsanchez.appareaseys.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImgFromUrl(url : String) = Picasso.with(context).load(url).into(this)