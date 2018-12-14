package com.example.darfe.databinding.util

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("app:dateFormat")
fun setDate(txt: TextView, date: Date?) {
    if(date != null){
        val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
        txt.text = dateFormat.format(date)
    }

}

@BindingAdapter("app:picasso")
fun setImage(img: ImageView, url: String?) {
    if (url != null) {
        Picasso.get()
            .load(Uri.parse(url))
            .into(img)
    }
}


