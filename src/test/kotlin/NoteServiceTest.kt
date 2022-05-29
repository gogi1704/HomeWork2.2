import MyExceptions.CommentIsNotDeleteException
import MyExceptions.NoteItemNotFoundExceptions
import org.junit.Assert.assertEquals
import org.junit.Test
import post.postContent.Comment
import post.postContent.Note

class NoteServiceTest {
    private val service = NoteService
    private val listComment = mutableListOf<Comment>()

    @Test
    fun addNote() {
        val result = service.addNote("", "")
        assertEquals(result, 1)
    }

    @Test
    fun editNote() {
        val result = service.editNote(0, "ee", "ss")
        assertEquals(true, result)
    }

    @Test
    fun getNoteById() {
        val note = Note(0, "", "")
        val result = service.getNoteById(0)
        assertEquals(note, result)


    }

    @Test
    fun deleteNote() {
        val result = service.deleteNote(0)
        assertEquals(result, true)

    }


    @Test
    fun getComments() {
        listComment.add(Comment(null, 0, "dsa", null, null))
        listComment.add(Comment(null, 2, "", null, null))
        val result = service.getComments(0, true)
        assertEquals(result, listComment)

    }

    @Test
    fun deleteComment() {
        service.addNote("", "")
        val result = service.deleteComment(0, 0)
        assertEquals(result, true)

    }

    @Test
    fun editComment() {
        service.addNote("", "")
        service.createComment(0, "")
        val result = service.editComment(0, "")
        assertEquals(result, true)
    }

    @Test
    fun restoreComment() {
        service.createComment(0,"")
        service.deleteComment(0, 0)
        val result = service.restoreComment(0, 0)
        assertEquals(result, true)
    }

    @Test(expected = CommentIsNotDeleteException::class)
    fun shouldThrowCommentIsNotDelete() {
        service.restoreComment(22, 1)
    }

    @Test(expected = NoteItemNotFoundExceptions::class)
    fun shouldThrowNoteItemNotFound() {
        service.createComment(22, "sd")
    }

    @Test
    fun createComment() {
        val result = service.createComment(0, "dsa")
        assertEquals(result, 1)
    }
}