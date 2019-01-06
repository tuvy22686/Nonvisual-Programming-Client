import model.SubBlock
import model.MainBlock
import util.BlockToJson
import java.net.Socket

fun main(args: Array<String>) {
    try {
        val socket = Socket(Constant.Connection.HOST_NAME, Constant.Connection.PORT_NUMBER)

        val mainData = mockDataJava()

        println(mainData)

        val connection = ConnectToServer(socket, mainData)
        connection.start()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun mockDataC(): String {
    return BlockToJson.run(
            MainBlock(0, MainBlock.LanguageType.C, "hello",
                    listOf(
                            SubBlock.ofIfInstance("true", listOf(
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

private fun mockDataC2(): String {
    return BlockToJson.run(
            MainBlock(0, MainBlock.LanguageType.C, "hello",
                    listOf(
                            SubBlock.ofPrintInstance()
                    )
            )
    )
}

private fun mockDataJava(): String {
    return BlockToJson.run(
            MainBlock(0, MainBlock.LanguageType.Java, "Hello",
                    listOf(
                            SubBlock.ofIntInstance(valueName = "a", value = "1"),
                            SubBlock.ofIntInstance(valueName = "a", value = "2"),
                            SubBlock.ofJavaNewIntArrayInstance(valueName = "b", values = listOf("1", "2", "3")),
                            SubBlock.ofJavaNewIntArrayInstance(valueName = "c", size = 3),
                            SubBlock.ofIntInstance(valueName = "a", value = "a+2"),
                            SubBlock.ofJavaHashMapInstance(valueName = "d", type1 = "String", type2 = "String"),
                            SubBlock.ofJavaCallFunctionInstance(functionName = "d.put", arguments = listOf("\"a\"", "\"red\"")),
                            SubBlock.ofJavaCallFunctionInstance(valueType = "String", valueName = "e", value = "d.get(\"a\")"),
                            SubBlock.ofPrintInstance(argument = "e")
                    )
            )
    )
}