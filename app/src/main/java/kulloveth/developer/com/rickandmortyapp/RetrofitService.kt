package kulloveth.developer.com.rickandmortyapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {



    companion object{
        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}