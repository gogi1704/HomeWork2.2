package chatServiceAtributes

class Chat(
    var myMassages: MutableMap<Int, Massage> = mutableMapOf(),
    var isReadChat: Boolean = false
) {

    fun  addMassage(massage: Massage){
        myMassages[massage.massageId] = massage
    }

    fun isReadAllMassages() {

        for (it in myMassages) {
            if (!it.value.isRead) {
                isReadChat = false
                break
            }else isReadChat = true

        }

    }


}