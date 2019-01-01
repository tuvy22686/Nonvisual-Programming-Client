package model

import com.google.gson.annotations.SerializedName

data class MainBlock(val userId: Long, val languageType: LanguageType, val fileName: String, val subBlocks: List<SubBlock>): Block() {

    enum class LanguageType {
        @SerializedName("0") C,
        @SerializedName("1") Java
    }
}