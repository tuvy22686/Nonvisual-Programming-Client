package model

data class SubBlock(val id: Int, val functionName: String, val arguments:List<String?>, val children: List<SubBlock?>): Block() {

    companion object {
        fun ofPrintInstance(argument: String = "\"Hello World\""): SubBlock {
            return SubBlock(
                    id = 0,
                    functionName = "printf",
                    arguments = listOf(argument),
                    children = listOf(null)
            )
        }

        fun onIfInstance(argument: String, children: List<SubBlock?>): SubBlock {
            return SubBlock(
                    id = 1,
                    functionName = "if",
                    arguments = arrayListOf(argument),
                    children = children
            )
        }
    }
}