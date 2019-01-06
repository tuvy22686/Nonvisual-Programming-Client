package model

data class SubBlock(val id: Int, val functionName: String, val valueName: String?, val values: List<String?>, val arguments:List<String?>, val children: List<SubBlock?>): Block() {

    companion object {
        fun ofPrintInstance(argument: String = "\"Hello World\""): SubBlock {
            return SubBlock(
                    id = 0,
                    functionName = "printf",
                    valueName = null,
                    values = listOf(null),
                    arguments = listOf(argument),
                    children = listOf(null)
            )
        }

        fun ofIfInstance(argument: String, children: List<SubBlock?>): SubBlock {
            return SubBlock(
                    id = 1,
                    functionName = "if",
                    valueName = null,
                    values = listOf(null),
                    arguments = listOf(argument),
                    children = children
            )
        }

        fun ofWhileInstance(argument: String, children: List<SubBlock?>): SubBlock {
            return SubBlock(
                    id = 2,
                    functionName = "while",
                    valueName = null,
                    values = listOf(null),
                    arguments = listOf(argument),
                    children = children
            )
        }

        fun ofIntInstance(valueName: String, value: String): SubBlock {
            return SubBlock(
                    id = 3,
                    functionName = "int",
                    valueName = valueName,
                    values = listOf(value),
                    arguments = listOf(null),
                    children = listOf(null)
            )
        }

        fun ofJavaStringInstance(valueName: String, value: String): SubBlock {
            return SubBlock(
                    id = 4,
                    functionName = "String",
                    valueName = valueName,
                    values = listOf(value),
                    arguments = listOf(null),
                    children = listOf(null)
            )
        }

        fun ofJavaNewIntArrayInstance(valueName: String, values: List<String>): SubBlock {
            return SubBlock(
                    id = 5,
                    functionName = "int[]",
                    valueName = valueName,
                    values = values,
                    arguments = listOf(null),
                    children = listOf(null)
            )
        }

        fun ofJavaNewIntArrayInstance(valueName: String, size: Int): SubBlock {
            return SubBlock(
                    id = 6,
                    functionName = "int[]",
                    valueName = valueName,
                    values = listOf(size.toString()),
                    arguments = listOf(null),
                    children = listOf(null)
            )
        }

        fun ofJavaElementArrayInstance(valueName: String, at: Int, value: String): SubBlock {
            return SubBlock(
                    id = 7,
                    functionName = "",
                    valueName = "$valueName[$at]",
                    values = listOf(value),
                    arguments = listOf(null),
                    children = listOf(null)
            )
        }

        fun ofJavaCallFunctionInstance(functionName: String, arguments: List<String?>): SubBlock {
            return SubBlock(
                    id = -1,
                    functionName = functionName,
                    valueName = null,
                    values = listOf(null),
                    arguments = arguments,
                    children = listOf(null)
            )
        }

        fun ofJavaCallFunctionInstance(valueType: String, valueName: String, value: String): SubBlock {
            return SubBlock(
                    id = -1,
                    functionName = valueType,
                    valueName = valueName,
                    values = listOf(value),
                    arguments = listOf(null),
                    children = listOf(null)
            )
        }

        fun ofJavaHashMapInstance(valueName: String, type1: String, type2: String): SubBlock {
            return SubBlock(
                    id = 8,
                    functionName = "Map<$type1,$type2>",
                    valueName = valueName,
                    values = listOf(null),
                    arguments = listOf(null),
                    children = listOf(null)
            )
        }
    }
}