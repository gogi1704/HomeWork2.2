import chatServiceAtributes.Chat
import chatServiceAtributes.Massage
import org.junit.Assert.assertEquals
import org.junit.Test

class ChatServiceTest {
    private val chatService = ChatService

    @Test
    fun getUnreadChatsCount() {
        val result = chatService.getUnreadChatsCount()
        assertEquals(result, 2)
    }

    @Test
    fun getChats() {
        val listOfChat = mutableListOf<Chat>()
        for (it in chatService.mapOfChats){
            listOfChat.add(it.value)
        }
        val result = chatService.getChats()
        assertEquals(listOfChat , result)
    }

    @Test
    fun getMassagesFromChat() {
        val result = chatService.getMassagesFromChat(1, 0, 1)
        val massageList = mutableListOf<Massage>( Massage(0, ""))
        assertEquals(result, massageList)
    }

    @Test
    fun createMassage() {
        val result = chatService.createMassage(Massage(1, ""), 1)
        assertEquals(result, true)
    }

    @Test
    fun deleteMassage() {
        val result = chatService.deleteMassage(0, 1)
        assertEquals(result, true)
    }

    @Test
    fun deleteChat() {
        val result = chatService.deleteChat(1)
        assertEquals(result, true)
    }

    @Test
    fun createChat() {
        val result = chatService.createChat(2)
        val assert = chatService.mapOfChats[2]
        assertEquals(assert, result)
    }

}