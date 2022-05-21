import Exceptions.PostNotFoundException
import post.Post
import post.postContent.Comment
import post.postContent.ReportComment

object WallService {
    private var postList = emptyArray<Post>()
    private var commentsList = emptyArray<Comment>()
    private var reportComments = emptyArray<ReportComment>()
    private var uniqueIdFromPost = 0
    private var uniqueIdFromComment = 0
    private val rangeReasonReport: IntRange = 0..8

    fun addPost(post: Post): Post {
        post.id = uniqueIdFromPost
        postList += post
        uniqueIdFromPost++
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
        var postContains = false
        for (post in postList) {
            if (post.id == comment.postId) {
                postContains = true
                break
            } else continue

        }
        if (postContains) {
            comment.id = uniqueIdFromComment
            commentsList += comment
            uniqueIdFromComment++
        } else throw PostNotFoundException("Пост с таким id : ${comment.postId} , не существует")
    }

    fun createReportComment(reportComment: ReportComment) {
        var commentContains = false

        for (comment in commentsList) {
            if (comment.id == reportComment.commentId) {
                commentContains = true
                break
            } else continue
        }

        if (reportComment.reason !in rangeReasonReport) {
            throw ReportReasonException("Неизвестная причина жалобы")
        }

        if (commentContains) {
            reportComments += reportComment
        } else throw PostNotFoundException("Комментарий с таким id : ${reportComment.commentId} , не существует")

    }


}