import com.google.gson.Gson
import model.OutputResult
import java.io.*
import java.net.Socket

class ConnectToServer(private val socket: Socket, private val data: String): Thread() {

    private lateinit var inputStream: InputStream
    private lateinit var bufferedReader: BufferedReader
    private lateinit var printWriter: PrintWriter

    override fun run() {
        try {
            inputStream = socket.getInputStream()
            bufferedReader = BufferedReader(InputStreamReader(inputStream))
            printWriter = PrintWriter(BufferedWriter(OutputStreamWriter(socket.getOutputStream())))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            printWriter.println(data)
            printWriter.flush()

            while (inputStream.available() == 0) {}

            val received = bufferedReader.readLine()
            val result = Gson().fromJson<OutputResult>(received, OutputResult::class.java)
            println(result)

            close()
        } catch (e: Exception) {
            e.printStackTrace()

            try {
                close()
                println("Finish")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun close() {
        bufferedReader.close()
        printWriter.close()
        inputStream.close()
        socket.close()
    }
}