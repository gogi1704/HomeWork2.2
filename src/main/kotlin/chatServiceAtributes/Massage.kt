package chatServiceAtributes

data class Massage(var massageId: Int, val text: String, var isRead: Boolean = false) {
}