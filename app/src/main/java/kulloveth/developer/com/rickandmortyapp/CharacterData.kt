package kulloveth.developer.com.rickandmortyapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharacterData (
    @SerializedName("name")
    val characterName:String):Serializable