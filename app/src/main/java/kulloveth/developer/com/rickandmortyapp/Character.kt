package kulloveth.developer.com.rickandmortyapp

import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName("name")
    val characterName:String)