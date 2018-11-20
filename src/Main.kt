import model.SubBlock
import model.MainBlock
import util.BlockToJson
import java.net.Socket

fun main(args: Array<String>) {
    try {
        val socket = Socket(Constant.Connection.HOST_NAME, Constant.Connection.PORT_NUMBER)

        val mainData = mockData()

        val connection = ConnectToServer(socket, mainData)
        connection.start()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun mockData(): String {
    return BlockToJson.run(
            MainBlock(0, "hello",
                    listOf(
                            SubBlock.onIfInstance("true", listOf(
                                    SubBlock.ofPrintInstance())
                            )
                    )
            )
    )

    // hello.c
    //    #include <stdio.h>
    //
    //    int main() {
    //        if (true) {
    //            printf("Hello World")
    //        }
    //        return 0;
    //    }
}