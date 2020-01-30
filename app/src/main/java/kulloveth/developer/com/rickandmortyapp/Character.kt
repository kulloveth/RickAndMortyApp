package kulloveth.developer.com.rickandmortyapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Character (
    @SerializedName("name")
    val characterName:String):Serializable