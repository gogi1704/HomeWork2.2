import org.junit.Assert.*
import org.junit.Test
import post.Post
import post.postContent.attachments.Attachments
import post.postContent.Like
import post.postContent.Repost
import post.postContent.View

class WallServiceTest {

    private val service = WallService
    val arrAttachments = emptyArray<Attachments>()

    @Test
    fun addPost() {
        val post = Post(2, 22, 22, 22, 22222, "Fisrt post", 1, 1, true, Like(), Repost(), View(1), 2,null,null,arrAttachments)
        val result = service.addPost(post)
        assertEquals(result, post)
    }

    @Test
    fun update_withTrue() {

        val post = Post(2, 11, 22, 22, 22222, "1 post", 1, 1, true, Like(), Repost(), View(1), 2 ,null,null,arrAttachments)
        val post2 = Post(2, 22, 22, 22, 22222, "2 post", 1, 1, true, Like(), Repost(), View(1), 2,null,null,arrAttachments)
        val post3 = Post(2, 333, 22, 22, 22222, "3 post", 1, 1, true, Like(), Repost(), View(1), 2,null,null,arrAttachments)

        service.addPost(post)
        service.addPost(post2)
        service.addPost(post3)

        val result = service.update(post2.copy(fromId = 1000))
        assertTrue(result)
    }


    @Test
    fun update_withfalse() {
        val post4 = Post(2, 11, 22, 22, 22222, "1 post", 1, 1, true, Like(), Repost(), View(1), 2,null,null,arrAttachments)
        val post2 = Post(2, 22, 22, 22, 22222, "2 post", 1, 1, true, Like(), Repost(), View(1), 2,null,null,arrAttachments)
        val post3 = Post(2, 333, 22, 22, 22222, "3 post", 1, 1, true, Like(), Repost(), View(1), 2,null,null,arrAttachments)

        service.addPost(post4)
        service.addPost(post2)
        service.addPost(post3)

        val post = Post(33, 333, 100, 22, 22222, "3 post", 1, 1, true, Like(), Repost(), View(1), 2,null,null,arrAttachments)

        val result = service.update(post)
        assertFalse(result)
    }
}