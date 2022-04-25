package post

import post.postContent.Like
import post.postContent.Repost
import post.postContent.View


data class Post(
    var id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Long,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friends_only: Boolean = false,
    val likes: Like,
    val reposts: Repost,
    val views: View,
    val postponedId: Int
)