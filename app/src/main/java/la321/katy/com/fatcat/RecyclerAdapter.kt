package la321.katy.com.fatcat

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import la321.katy.com.fatcat.model.FeedingDate
import java.util.*

class RecyclerAdapter(var feedings: List<FeedingDate>): RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>()  {

    inner class RecyclerHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_child, parent, false)) {
            private var mTitleView: TextView? = null
            init {
                mTitleView = itemView.findViewById(R.id.tv_date)
            }


            fun bind(feeding: FeedingDate) {
                val dateLong = feeding.title.toLong()
                val cal = GregorianCalendar.getInstance()
                cal.timeInMillis = dateLong
                val month = cal.get(Calendar.MONTH)+1
                var monthString:String? = null
                if (month == 6){
                    monthString = "June"
                }
                val day = "${cal.get( Calendar.DATE)} $monthString"
                mTitleView?.text = day
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecyclerHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        val movie:FeedingDate = feedings[position]
        holder.bind(movie)
    }

    override fun getItemCount() = feedings.size
}