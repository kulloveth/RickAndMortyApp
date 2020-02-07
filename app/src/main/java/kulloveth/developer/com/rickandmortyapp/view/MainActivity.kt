package kulloveth.developer.com.rickandmortyapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kulloveth.developer.com.rickandmortyapp.MainAdapter
import kulloveth.developer.com.rickandmortyapp.MainAdapter.OnItemClickedListener
import kulloveth.developer.com.rickandmortyapp.R
import kulloveth.developer.com.rickandmortyapp.models.Result
import kulloveth.developer.com.rickandmortyapp.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = MainAdapter(object : OnItemClickedListener {
            override fun onItemClicked(result: Result) {
                val selectedItem = result.id
                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra(MainAdapter.CHARACTER_ID, selectedItem)
                intent.putExtra(MainAdapter.CHARACTER_NAME, result.name)
                intent.putExtra(MainAdapter.CHARACTER_IMAGE, result.photoUrl)
                intent.putExtra(MainAdapter.CHARACTER_STATUS, result.status)
                intent.putExtra(MainAdapter.CHARACTER_SPECIE, result.species)
                intent.putExtra(MainAdapter.CHARACTER_GENDER, result.gender)
                startActivity(intent)

            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        viewModel.getCharacters().observe(this, Observer {
            adapter.setupData(it.results)
            adapter.notifyDataSetChanged()
        })

    }
}
