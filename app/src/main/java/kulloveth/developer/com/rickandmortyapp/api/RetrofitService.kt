package kulloveth.developer.com.rickandmortyapp.api

import io.reactivex.Single
import kulloveth.developer.com.rickandmortyapp.models.CharacterData
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("api/character/")
    fun fetchCharacterName(): Single<Response<CharacterData>>


    companion object {
        fun getRetrofitInstance(): RetrofitService {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}