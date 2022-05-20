package post.postContent.attachments

import post.postContent.Note

data class NoteAttachments(
    override val type: String = "note",
    val note: Note
) : Attachments
