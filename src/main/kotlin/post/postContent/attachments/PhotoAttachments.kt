package post.postContent.attachments

import post.postContent.Photo

data class PhotoAttachments(
    override val type: String = "photo",
    val photo: Photo
) : Attachments
