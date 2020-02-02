package kulloveth.developer.com.rickandmortyapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kulloveth.developer.com.rickandmortyapp.api.RetrofitService
import kulloveth.developer.com.rickandmortyapp.models.CharacterData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    private val characters: MutableLiveData<CharacterData> by lazy {
        MutableLiveData<CharacterData>().also {
            fetchName()
        }

    }

    fun getCharacters(): LiveData<CharacterData> {
        return characters
    }

    private fun fetchName() {
        val apiInterface = RetrofitService.getRetrofitInstance().fetchCharacterName()
        apiInterface.enqueue(object : Callback<CharacterData> {

            override fun onFailure(call: Call<CharacterData>, t: Throwable) {
            }

            override fun onResponse(call: Call<CharacterData>, response: Response<CharacterData>) {
                characters.value = response.body()
                Log.d("character", "" + response.body())
            }

        })
    }

}