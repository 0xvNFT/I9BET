package com.i9betstoryphat.i9bet.utils

import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.data.Content

object AppCache {

    fun getListContent(): ArrayList<Content> {
        var list = ArrayList<Content>()
        list.add(
            Content(
                0,
                R.drawable.image_content_1,
                "Thiều Quang Vừa Lúc",
                "Một ngày, thầy đồ Thanh bất chợt phát hiện đứa bé ..."
            )
        )
        list.add(
            Content(
                1,
                R.drawable.image_content_2,
                "One piece film: Red",
                "One Piece Film: Red là bộ phim hoạt hình anime của Nhật Bản thuộc thể loại kỳ ảo, hành động-"
            )
        )
        list.add(
            Content(
                2,
                R.drawable.image_content_4,
                "ĐẠI SƯ HUYNH KHÔNG CÓ GÌ LẠ",
                "Xuyên qua thế giới Tiên Hiệp, nắm giữ một gương mặt của nhân vật chính."
            )
        )
        return list
    }
}