import post.Post

object WallService {
    private var postList = emptyArray<Post>()

    fun addPost(post: Post): Post {
        postList += post
        post.id = postList.indexOf(post)
        return post
    }

    fun print() {
        for (post in postList) {
            println(post)
        }
    }

    fun update(post: Post): Boolean {
        val item = postList[post.id].copy(
            fromId = post.fromId,
            createdBy = post.createdBy,
            text = post.text,
            replyOwnerId = post.replyOwnerId,
            replyPostId = post.replyPostId,
            friends_only = post.friends_only,
            likes = post.likes,
            reposts = post.reposts,
            views = post.views,
            postponedId = post.postponedId
        )
        if (item.id == post.id) {
            postList[post.id] = item
            return true
        } else
            return false

    }
}