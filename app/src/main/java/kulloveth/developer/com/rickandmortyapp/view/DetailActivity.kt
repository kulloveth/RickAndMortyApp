package kulloveth.developer.com.rickandmortyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.activity_detail.*
import kulloveth.developer.com.rickandmortyapp.MainAdapter
import kulloveth.developer.com.rickandmortyapp.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if(intent.hasExtra(MainAdapter.CHARACTER_ID)){
            name.text = intent.getStringExtra(MainAdapter.CHARACTER_NAME)
            status.text = intent.getStringExtra(MainAdapter.CHARACTER_STATUS)
            specie.text = intent.getStringExtra(MainAdapter.CHARACTER_SPECIE)
            gender.text = intent.getStringExtra(MainAdapter.CHARACTER_GENDER)
            Glide.with(this).load(intent.getStringExtra(MainAdapter.CHARACTER_IMAGE))
                .centerCrop().transform(CircleCrop()).into(photo)
        }
    }
}
