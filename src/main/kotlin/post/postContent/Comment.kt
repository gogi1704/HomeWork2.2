package post.postContent

class Comment(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose:Boolean,
    val canOpen:Boolean,
) {

}


//Информация о комментариях к записи, объект с полями:
//count (integer) — количество комментариев;
//can_post* (integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
//groups_can_post (integer, [0,1]) — информация о том, могут ли сообщества комментировать запись;
//can_close(boolean) — может ли текущий пользователь закрыть комментарии к записи;
//can_open(boolean) — может ли текущий пользователь открыть комментарии к записи.//