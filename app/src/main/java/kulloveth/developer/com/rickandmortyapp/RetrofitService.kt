package kulloveth.developer.com.rickandmortyapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("api/character/")
    fun fetchCharacterName(): Call<CharacterData>


    companion object {
        fun getRetrofitInstance(): RetrofitService {
            val retrofit:Retrofit= Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}