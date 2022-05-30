package post.postContent

data class Comment(
    val postId:Int?,
    var id : Int,
    val massage:String,
    val fromId : Int?,
    val date: Int?
) {
}