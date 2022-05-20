package post

import post.postContent.*
import post.postContent.attachments.Attachments


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
    val reposts: Repost?,
    val views: View,
    val postponedId: Int,
    val copyHistory:Array<Post>?,
    val geo: Geo?,
    val attachments:Array<Attachments>
)