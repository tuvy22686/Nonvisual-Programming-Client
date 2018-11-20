package model

data class MainBlock(val userId: Long, val fileName: String, val subBlocks: List<SubBlock>): Block()