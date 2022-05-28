import post.postContent.Comment

data class NoteServicePair<item, list>(var note: item, var comments: MutableList<list> = mutableListOf()) {

    fun addComment( comment: Comment){
        comment as list
        comments.add(comment)
    }

    fun getList():List<Comment>{
      return comments as List<Comment>
    }


}