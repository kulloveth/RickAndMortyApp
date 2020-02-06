package kulloveth.developer.com.rickandmortyapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kulloveth.developer.com.rickandmortyapp.MainAdapter
import kulloveth.developer.com.rickandmortyapp.R
import kulloveth.developer.com.rickandmortyapp.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = MainAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this,2)
        viewModel.getCharacters().observe(this, Observer {
            adapter.setupData(it.results)
            adapter.notifyDataSetChanged()
        })

    }
}
