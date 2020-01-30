package kulloveth.developer.com.rickandmortyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var characterDataList:List<CharacterData> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = characterDataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data : CharacterData= characterDataList[position]
        holder.itemView.name.text = data.characterName
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}