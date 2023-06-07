package com.i9betstoryphat.i9bet.utils

import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.data.Content
import com.i9betstoryphat.i9bet.data.ContentDetail

object AppCache {

    var contentCurrent = Content()

    fun getListContent(): ArrayList<Content> {
        var list = ArrayList<Content>()
        list.add(
            Content(
                0,
                R.drawable.image_content_1,
                "Thiều Quang Vừa Lúc",
                "Một ngày, thầy đồ Thanh bất chợt phát hiện đứa bé ..."
            ,R.string.text_content_love
            )
        )
        list.add(
            Content(
                1,
                R.drawable.image_content_2,
                "One piece film: Red",
                "One Piece Film: Red là bộ phim hoạt hình anime của Nhật Bản thuộc thể loại kỳ ảo, hành động-"
            ,R.string.content_one_piece
            )
        )
        list.add(
            Content(
                2,
                R.drawable.image_content_4,
                "ĐẠI SƯ HUYNH KHÔNG CÓ GÌ LẠ",
                "Xuyên qua thế giới Tiên Hiệp, nắm giữ một gương mặt của nhân vật chính."  ,R.string.content_one_piece
            )
        )
        list.add(
            Content(
                3,
                R.drawable.image_content_4,
                "ĐẠI SƯ HUYNH KHÔNG CÓ GÌ LẠ",
                "Xuyên qua thế giới Tiên Hiệp, nắm giữ một gương mặt của nhân vật chính."  ,R.string.content_one_piece
            )
        )
        list.add(
            Content(
                4,
                R.drawable.image_content_4,
                "ĐẠI SƯ HUYNH KHÔNG CÓ GÌ LẠ",
                "Xuyên qua thế giới Tiên Hiệp, nắm giữ một gương mặt của nhân vật chính."  ,R.string.content_one_piece
            )
        )
        return list
    }

    fun getListContentDetail(): ArrayList<ContentDetail> {
        var list = ArrayList<ContentDetail>()
        list.add(
            ContentDetail(
                0,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga."
          , 440
            )
        )
        list.add(
            ContentDetail(
                1,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga."
                , 490
            )
        )
        list.add(
            ContentDetail(
                2,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga."
                , 400
            )
        )
        list.add(
            ContentDetail(
                3,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga."
                , 456
            )
        )
        list.add(
            ContentDetail(
                4,
                R.drawable.image_content_detail_1,
                "ROSEN GARTEN SAGA",
                "Truyện tranh Rosen Garten Saga được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Rosen Garten Saga."
                , 478
            )
        )
        return list
    }


}