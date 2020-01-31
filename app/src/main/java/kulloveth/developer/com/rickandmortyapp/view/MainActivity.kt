package kulloveth.developer.com.rickandmortyapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kulloveth.developer.com.rickandmortyapp.MainAdapter
import kulloveth.developer.com.rickandmortyapp.R
import kulloveth.developer.com.rickandmortyapp.api.RetrofitService
import kulloveth.developer.com.rickandmortyapp.models.CharacterData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = MainAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = RetrofitService.getRetrofitInstance().fetchCharacterName()
        apiInterface.enqueue(object : Callback<CharacterData> {
            override fun onFailure(call: Call<CharacterData>, t: Throwable) {

            }

            override fun onResponse(call: Call<CharacterData>, response: Response<CharacterData>) {
                // characterDataList = response.body()
                response.body()?.let {
                    adapter.setupData(it.results)
                    adapter.notifyDataSetChanged()
                }
                Log.d("character", "" + response.body())
            }

        })


    }
}
