package kulloveth.developer.com.rickandmortyapp


import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("api/character/")
    fun fetchCharacterName(): Call<List<Character>>
}