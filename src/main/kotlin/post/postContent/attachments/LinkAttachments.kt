package post.postContent.attachments

import post.postContent.Link

data class LinkAttachments(
    override val type: String = "link",
    val link: Link
) : Attachments
