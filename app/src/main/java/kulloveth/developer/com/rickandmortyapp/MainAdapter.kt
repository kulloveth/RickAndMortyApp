package kulloveth.developer.com.rickandmortyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.rv_item.view.*
import kulloveth.developer.com.rickandmortyapp.models.Result

class MainAdapter(val listener: OnItemClickedListener) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    companion object {
        var onItemClickedListener: OnItemClickedListener? = null
        val CHARACTER_ID = "characterId"
        val CHARACTER_NAME = "characterName"
        val CHARACTER_IMAGE = "characterImage"
        val CHARACTER_STATUS = "characterStatus"
        val CHARACTER_SPECIE= "characterSpecie"
        val CHARACTER_GENDER = "characterGender"
    }

    private var resultList: List<Result> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    fun setupData(characterDataList: List<Result>) {
        this.resultList = characterDataList

    }

    override fun getItemCount(): Int = resultList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onItemClickedListener = listener
        val data: Result = resultList[position]
        holder.itemView.name.text = data.name
        Glide.with(holder.itemView).load(data.photoUrl)
            .centerCrop().transform(CircleCrop())
            .into(holder.itemView.photo)

        holder.itemView.setOnClickListener {
            onItemClickedListener.let {
                onItemClickedListener?.onItemClicked(data)
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface OnItemClickedListener {
        fun onItemClicked(result: Result)
    }
}


