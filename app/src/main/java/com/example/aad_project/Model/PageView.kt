package com.example.aad_project.Model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class BadgeViewModel {
    companion object {
        @JvmStatic
        @BindingAdapter("bind:badgeUrl")
        fun loadBadge(view: ImageView, badgeUrl: String?) {
            Picasso.get()
                .load(badgeUrl)
                .into(view)
        }
    }
}