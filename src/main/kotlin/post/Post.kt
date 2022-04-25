package post

import post.postContent.Like
import post.postContent.Repost
import post.postContent.View


data class Post(
    var id: Int = -1,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Long,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friends_only: Boolean = false,
//    val comments: Comment,  //
//    val copyright: Copyright,  //
    val likes: Like,  //
    val reposts: Repost,  //
    val views: View,  //
//    val postType: String,
//    val signerId: Int,
//    val canPin: Boolean = true,
//    val canDelete: Boolean = true,
//    val canEdit: Boolean = false,
//    val isPinned: Boolean,
//    val markedAsAds: Boolean,
//    val isFavorite: Boolean,
//    val donut: Donut,   // 
    val postponedId: Int

) {


}
