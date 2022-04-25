package post.postContent

class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val canPublishFreeCopy: Boolean,
    val editMode: String

) {


}


//is_donut (boolean) — запись доступна только платным подписчикам VK post.postContent.Donut;
//paid_duration (integer) — время, в течение которого запись будет доступна только платным подписчикам VK post.postContent.Donut;
//placeholder (object) — заглушка для пользователей, которые не оформили подписку VK post.postContent.Donut. Отображается вместо содержимого записи.
//can_publish_free_copy (boolean) — можно ли открыть запись для всех пользователей, а не только подписчиков VK post.postContent.Donut;
//edit_mode (string) — информация о том, какие значения VK post.postContent.Donut можно изменить в записи. Возможные значения:
//all — всю информацию о VK post.postContent.Donut.
//duration — время, в течение которого запись будет доступна только платным подписчикам VK post.postContent.Donut.