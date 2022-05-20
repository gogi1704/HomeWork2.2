import Exceptions.PostNotFoundException
import post.Post
import post.postContent.Comment
import post.postContent.ReportComment

object WallService {
    private var postList = emptyArray<Post>()
    private var commentsList = emptyArray<Comment>()
    private var reportComments = emptyArray<ReportComment>()
    private var uniqueId = 0
    private val rangeReasonReport:IntRange = 0..8

    fun addPost(post: Post): Post {
        post.id = uniqueId
        postList += post
        uniqueId++
        return post
    }

    fun update(post: Post): Boolean {
        if (postList.size < post.id) {
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
                postponedId = post.postponedId,
                geo = post.geo,
                copyHistory = post.copyHistory,
                attachments = post.attachments

            )
            return true
        }

    }

    fun createComment(comment: Comment) {
        for (post in postList) {
            if (post.id == comment.postId) {
                commentsList + comment
            } else throw PostNotFoundException("Пост с таким id : ${comment.postId} , не существует")
        }

    }

    fun createReportComment(reportComment: ReportComment) {
        for (post in postList) {
            if (reportComment.commentId !in rangeReasonReport){
                throw ReportReasonException("Неизвестная причина жалобы")
            }
            if (post.id == reportComment.commentId) {
                reportComments + reportComment
            } else throw PostNotFoundException("Пост с таким id : ${reportComment.commentId} , не существует")
        }

    }


}