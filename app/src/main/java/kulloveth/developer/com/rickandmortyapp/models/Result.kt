package kulloveth.developer.com.rickandmortyapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Result(

    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String
) : Serializable