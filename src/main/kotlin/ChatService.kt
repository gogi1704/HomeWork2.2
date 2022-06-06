import MyExceptions.ChatNotFoundException
import MyExceptions.MassageNotFoundException
import chatServiceAtributes.Chat
import chatServiceAtributes.Massage

object ChatService {
    private var uniqueIdMassages = 0
    var mapOfChats = mutableMapOf<Int, Chat>()


    fun getUnreadChatsCount(): Int {


        return mapOfChats.isNotReadChatsCount()
    }

    fun getChats(): List<Chat> {
        val filteredList = mapOfChats
            .map { it.value }
        return filteredList.toList()
    }

    fun getMassagesFromChat(chatId: Int, lastMassageId: Int, countOfMassages: Int): List<Massage> {
        val chat = mapOfChats[chatId]?.myMassages
        val newChat = chat?.filterValues { massage -> massage.massageId >= lastMassageId }
        val filterChat = newChat?.asSequence()
            ?.map { it.value }
            ?.take(countOfMassages)
        return filterChat?.toList()!!
    }

    fun createMassage(massage: Massage, companionId: Int): Boolean {
        if (!mapOfChats.containsKey(companionId)) {
            createChat(companionId)
            massage.massageId = uniqueIdMassages
            mapOfChats[companionId]?.addMassage(massage)
        } else {
            massage.massageId = uniqueIdMassages
            mapOfChats[companionId]?.addMassage(massage)
            massage.massageId = uniqueIdMassages

        }
        uniqueIdMassages++
        return true
    }

    fun deleteMassage(massageId: Int, companionId: Int): Boolean {
        if (mapOfChats[companionId]?.myMassages?.containsKey(massageId) == true) {
            mapOfChats[companionId]?.myMassages?.remove(massageId)
            return true
        } else throw MassageNotFoundException("Данное сообщение не найдено")
    }

     fun createChat(companionId: Int): Chat {
        val chat = Chat()
        mapOfChats[companionId] = chat
        return chat
    }

    fun deleteChat(companionId: Int): Boolean {
        if (mapOfChats.containsKey(companionId)) {
            mapOfChats.remove(companionId)
            return true
        } else throw ChatNotFoundException("Чат с таким ID не найден")

    }


    private fun MutableMap<Int, Chat>.isNotReadChatsCount(): Int {
        var count = 0
        for (it in this) {
            it.value.isReadAllMassages()
            if (!it.value.isReadChat) {
                count++
                continue
            }
        }
        return count
    }

}


