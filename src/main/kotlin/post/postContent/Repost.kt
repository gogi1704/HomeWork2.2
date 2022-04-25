package post.postContent

class Repost(val count: Int = 0, val userReposted: Boolean = true) {

}

//	Информация о репостах записи («Рассказать друзьям»), объект с полями:
//count (integer) — число пользователей, скопировавших запись;
//user_reposted* (integer, [0,1]) — наличие репоста от текущего пользователя (1 — есть, 0 — нет).