package post.postContent

abstract class Attachments(val type: String)


class PhotoAttachments(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo640: String
) : Attachments("Photo")

class VideoAttachments(
    val id: Int,
    val ownerId: Int,
    val view: Int,
    val comments: Int,
    val player: String
) : Attachments("Video")

class LinkAttachments(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
) : Attachments("Link")

class NoteAttachments(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
) : Attachments("Note")

class AudioAttachments(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val url :String,
    val albumId: Int,
    val artist: String,
    val description: String,
) : Attachments("Audio")



