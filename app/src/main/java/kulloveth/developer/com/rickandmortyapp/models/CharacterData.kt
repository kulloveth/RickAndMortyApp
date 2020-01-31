package kulloveth.developer.com.rickandmortyapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharacterData(

    @SerializedName("results")
    val results: List<Result>
) : Serializable