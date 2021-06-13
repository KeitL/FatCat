package la321.katy.com.fatcat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import la321.katy.com.fatcat.model.Feeding

class RecyclerAdapter(var feedings: List<Feeding>): RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>()  {

    //1
    inner class RecyclerHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_child, parent, false)) {
            private var mTitleView: TextView? = null
            init {
                mTitleView = itemView.findViewById(R.id.tv_date)
            }

            fun bind(feeding: Feeding) {
                mTitleView?.text = feeding.feedingTime
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecyclerHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        val movie:Feeding = feedings[position]
        holder.bind(movie)
    }

    override fun getItemCount() = feedings.size
}