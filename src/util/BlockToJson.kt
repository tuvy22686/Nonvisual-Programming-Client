package util

import com.google.gson.Gson
import model.Block

object BlockToJson {

    fun run(block: Block): String {
        return Gson().toJson(block)
    }
}