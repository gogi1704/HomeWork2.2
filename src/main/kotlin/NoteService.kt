import MyExceptions.CommentIsNotDeleteException
import MyExceptions.NoteItemNotFoundExceptions
import post.postContent.Comment
import post.postContent.Note

object NoteService {
    private var uniqueIdFromNote: Int = 0
    private var uniqueIdFromComment: Int = 0
    var mapOfNotes = mutableMapOf<Int, NoteServicePair<Note, Comment>>()
    var mapOfComments = mutableMapOf<Int, Comment>()

    fun addNote(title: String, text: String): Int {
        val note = NoteServicePair(Note(id = uniqueIdFromNote, title = title, text = text), mutableListOf<Comment>())
        mapOfNotes[uniqueIdFromNote] = note
        uniqueIdFromNote++
        return note.note.id
    }

    fun editNote(noteId: Int, title: String, text: String): Boolean {
        val noteItem = mapOfNotes[noteId]
        val newNoteItem =
            noteItem?.copy(note = Note(title = title, text = text, id = noteItem.note.id)) as NoteServicePair
        mapOfNotes[noteId] = newNoteItem
        return true
    }

    fun getNoteById(noteId: Int): Note {
        if (mapOfNotes.containsKey(noteId)) {
            return mapOfNotes[noteId]?.note as Note
        } else throw NoteItemNotFoundExceptions("Заметка с таким id: $noteId не обнаружена")
    }

    fun deleteNote(noteId: Int): Boolean {
        if (mapOfNotes.containsKey(noteId)) {
            mapOfNotes.remove(noteId)
            return true
        } else throw NoteItemNotFoundExceptions("Заметка с таким id: $noteId не обнаружена")
    }

    fun createComment(noteId: Int, massage: String): Int {
        if (mapOfNotes.containsKey(noteId)) {
            val comment = Comment(null, uniqueIdFromComment, massage, null, null)
            mapOfNotes[noteId]?.addComment(comment)
            mapOfComments[comment.id] = comment
            uniqueIdFromComment++
            return comment.id
        } else throw NoteItemNotFoundExceptions("Заметка с таким id: $noteId не обнаружена")
    }

    fun getComments(noteId: Int, sortById: Boolean): List<Comment> {
        return if (sortById) {
            mapOfNotes[noteId]?.getList() as List<Comment>
        } else mapOfNotes[noteId]?.getList()?.reversed() as List<Comment>
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        if (mapOfNotes.containsKey(noteId) && mapOfComments.containsKey(commentId)) {
            val comment = mapOfComments[commentId]
            mapOfNotes[noteId]?.comments?.remove(comment)
            return true
        } else throw NoteItemNotFoundExceptions("Заметка с таким id: $noteId не обнаружена")

    }

    fun editComment(commentId: Int, massage: String): Boolean {
        for (it in mapOfNotes) {
            for (comment in it.value.comments) {
                if (comment.id == commentId) {
                    val newComment = comment.copy(massage = massage)
                    it.value.comments[commentId] = newComment
                    mapOfComments[commentId] = newComment
                    return true
                }
            }
        }
        return false
    }

    fun restoreComment(noteId: Int, commentId: Int): Boolean {
        val comment = mapOfComments[commentId]
        if (mapOfNotes[noteId]?.comments?.contains(comment) == false) {
            mapOfNotes[noteId]?.addComment(comment as Comment)
            return true
        } else throw CommentIsNotDeleteException("Нет доступа к комментарию")
    }

}
