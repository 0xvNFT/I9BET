package com.i9betstoryphat.i9bet.utils

import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.data.Content

object AppCache {

    var contentCurrent = Content()

    fun getListContent(): ArrayList<Content> {
        var list = ArrayList<Content>()
        list.add(
            Content(
                0,
                R.drawable.image_content_1,
                "Thiều Quang Vừa Lúc",
                "Một ngày, thầy đồ Thanh bất chợt phát hiện đứa bé ...", 0, R.string.text_content_love
            )
        )
        list.add(
            Content(
                1,
                R.drawable.image_content_2,
                "One piece film: Red",
                "One Piece Film: Red là bộ phim hoạt hình anime của Nhật Bản thuộc thể loại kỳ ảo, hành động-",
                0, R.string.content_one_piece
            )
        )
        list.add(
            Content(
                2,
                R.drawable.image_content_4,
                "ĐẠI SƯ HUYNH KHÔNG CÓ GÌ LẠ",
                "Xuyên qua thế giới Tiên Hiệp, nắm giữ một gương mặt của nhân vật chính.",
                0,  R.string.content_one_piece
            )
        )
        list.add(
            Content(
                3,
                R.drawable.image_content_4,
                "ĐẠI SƯ HUYNH KHÔNG CÓ GÌ LẠ",
                "Xuyên qua thế giới Tiên Hiệp, nắm giữ một gương mặt của nhân vật chính.",
                0,  R.string.content_one_piece
            )
        )
        list.add(
            Content(
                4,
                R.drawable.image_content_4,
                "ĐẠI SƯ HUYNH KHÔNG CÓ GÌ LẠ",
                "Xuyên qua thế giới Tiên Hiệp, nắm giữ một gương mặt của nhân vật chính.",
                0, R.string.content_one_piece
            )
        )
        return list
    }

    fun getListContentDetail(): ArrayList<Content> {
        var list = ArrayList<Content>()
        list.add(
            Content(
                0,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga.",
                440, R.string.text_content_love
            )
        )
        list.add(
            Content(
                1,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga.",
                490, R.string.text_content_love
            )
        )
        list.add(
            Content(
                2,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga.",
                400, R.string.text_content_love
            )
        )
        list.add(
            Content(
                3,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga.",
                456, R.string.text_content_love
            )
        )
        list.add(
            Content(
                4,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga.",
                478, R.string.text_content_love
            )
        )
        return list
    }

    fun saveLoveItem(item: Content) {
        var list = AppUtils.getLoveStory()
        if (list.isNullOrEmpty()) {
            list = ArrayList()
        }
        list.add(item)
        AppUtils.saveLoveStory(list)

    }


}