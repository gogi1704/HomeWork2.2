import post.Post

object WallService {
    private var postList = emptyArray<Post>()
    private var uniqueId = 0

    fun addPost(post: Post): Post {
        post.id = uniqueId
        postList += post
        uniqueId ++
        return post
    }

    fun update(post: Post): Boolean {
        if (postList.size  < post.id) {
            return false
        } else {
            postList[post.id] = postList[post.id].copy(

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
            return true
        }

    }
}