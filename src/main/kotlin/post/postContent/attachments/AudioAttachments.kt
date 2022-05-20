package post.postContent.attachments

import post.postContent.Audio

data class AudioAttachments(
    override val type: String = "audio",
    val audio: Audio
) : Attachments
