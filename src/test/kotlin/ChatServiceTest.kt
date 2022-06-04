import ChatService.getList
import chatServiceAtributes.Massage
import org.junit.Assert.assertEquals
import org.junit.Test

class ChatServiceTest {
    private val chatService = ChatService
    private val mapOfMassage = mutableMapOf<Int, Massage>()

    @Test
    fun getUnreadChatsCount() {
        val result = chatService.getUnreadChatsCount()
        assertEquals(result, 2)
    }

    @Test
    fun getChats() {
        val listOfChat = chatService.mapOfChats.getList()
        val result = chatService.getChats()
        assertEquals(listOfChat , result)
    }

    @Test
    fun getMassagesFromChat() {
        val result = chatService.getMassagesFromChat(1, 0, 1)
        mapOfMassage[0] = Massage(0, "")
        assertEquals(result, mapOfMassage)
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