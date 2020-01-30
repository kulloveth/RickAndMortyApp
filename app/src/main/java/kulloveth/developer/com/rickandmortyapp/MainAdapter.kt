package kulloveth.developer.com.rickandmortyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
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
        val data: Result = resultList[position]
        holder.itemView.name.text = data.name
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}


