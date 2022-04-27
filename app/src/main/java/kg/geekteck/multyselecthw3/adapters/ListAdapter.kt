package kg.geekteck.multyselecthw3.adapters

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geekteck.multyselecthw3.R
import kg.geekteck.multyselecthw3.databinding.ItemBinding
import kg.geekteck.multyselecthw3.interfaces.Click
import kg.geekteck.multyselecthw3.models.Picture

class ListAdapter(
    private var list: ArrayList<Picture>,
    private var multiChoice: Click
) : RecyclerView.Adapter<ListAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val picture = list[position]
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            picture.isSelect = !picture.isSelect
            multiChoice.miltyChoice(picture)
            holder.sel(picture)
        }
    }

    override fun getItemCount() = list.size

    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBinding.bind(itemView)
        fun bind(history: Picture) = with(binding) {
            Glide.with(binding.root).load(history.uri).into(ivMain)
            if (history.isSelect) {
                ivMain.setColorFilter(R.color.black, PorterDuff.Mode.DARKEN)
            } else {
                ivMain.clearColorFilter()
            }
        }

        fun sel(picture: Picture) {
            if (picture.isSelect) {
                binding.ivMain.setColorFilter(R.color.black, PorterDuff.Mode.DARKEN)
            } else {
                binding.ivMain.clearColorFilter()
            }
        }
    }
}