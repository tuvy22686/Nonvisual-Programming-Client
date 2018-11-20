import model.SubBlock
import model.MainBlock
import util.BlockToJson
import java.net.Socket

fun main(args: Array<String>) {
    try {
        val socket = Socket(Constant.Connection.HOST_NAME, Constant.Connection.PORT_NUMBER)
        val mainData = BlockToJson.run(
                MainBlock(0, "hello", listOf(
                        SubBlock.onIfInstance("true", listOf(
                                SubBlock.ofPrintInstance())))))
        val connection = ConnectToServer(socket, mainData)
        connection.start()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}