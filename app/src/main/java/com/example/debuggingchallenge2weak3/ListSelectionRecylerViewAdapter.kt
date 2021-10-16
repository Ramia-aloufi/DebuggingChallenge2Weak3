import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.debuggingchallenge2weak3.R
import com.example.debuggingchallenge2weak3.contryesCapital

class ListSelectionRecyclerViewAdapter( val stateAndCapitals: ArrayList<contryesCapital>) :
    RecyclerView.Adapter<ListSelectionRecyclerViewAdapter.ListSelectionViewHolder>() {
    class ListSelectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val listPosition: TextView = itemView.findViewById(R.id.itemNumber)
    val listTitle: TextView = itemView.findViewById(R.id.itemString)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_selection_view_holder, parent, false)

        return ListSelectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {

            holder.listPosition.text = stateAndCapitals[position].capital
            holder.listTitle.text = stateAndCapitals[position].country



    }

    override fun getItemCount(): Int {
        return stateAndCapitals.size
    }

}