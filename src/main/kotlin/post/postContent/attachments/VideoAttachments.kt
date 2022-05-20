package post.postContent.attachments

import post.postContent.Video

data class VideoAttachments(
    override val type: String = "video",
    val video: Video
) : Attachments
