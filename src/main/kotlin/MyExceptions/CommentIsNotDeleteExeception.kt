package MyExceptions
class CommentIsNotDeleteException(private val text:String):Exception(text){}