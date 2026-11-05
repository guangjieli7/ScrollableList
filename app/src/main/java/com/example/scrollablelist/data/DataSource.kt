package com.example.scrollablelist.data
import com.example.scrollablelist.model.Bee
import com.example.scrollablelist.R

class DataSource {
    fun listItems(): List<Bee>{
        return listOf<Bee>(
            Bee(R.string.caption_1, R.drawable.honey_bee),
            Bee(R.string.caption_2, R.drawable.bumblebee),
            Bee(R.string.caption_3, R.drawable.stingless_bee),
            Bee(R.string.caption_4, R.drawable.carpenter_bee),
            Bee(R.string.caption_5, R.drawable.leafcutter_bee),
            Bee(R.string.caption_6, R.drawable.mason_bee),
            Bee(R.string.caption_7, R.drawable.orchid_bee),
            Bee(R.string.caption_8, R.drawable.sweat_bee),
            Bee(R.string.caption_9, R.drawable.mining_bee),
            Bee(R.string.caption_10, R.drawable.plasterer_bee)
        )
    }
}