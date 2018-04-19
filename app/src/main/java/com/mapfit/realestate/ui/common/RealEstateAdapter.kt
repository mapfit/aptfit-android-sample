package com.mapfit.realestate.ui.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mapfit.realestate.R
import com.mapfit.realestate.model.RealEstate
import com.mapfit.realestate.util.GlideApp

class RealEstateAdapter(
    private val clickListener: (RealEstate) -> Unit,
    private val footerClickListener: () -> Unit,
    private val itemType: ItemType
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val items = mutableListOf<RealEstate>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val type: ItemType = ItemType.typeForValue(viewType) ?: ItemType.NONE

        return when (type) {
            ItemType.VERTICAL -> VerticalListVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_realestate_vertical,
                    parent,
                    false
                )
            )

            ItemType.HORIZONTAL -> HorizontalListVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_realestate_horizontal,
                    parent,
                    false
                )
            )

            ItemType.FOOTER -> FooterVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.widget_mapfit_footer,
                    parent,
                    false
                )
            )

            ItemType.NONE -> object : RecyclerView.ViewHolder(parent) {}
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if (position == items.size  && itemType != ItemType.HORIZONTAL) {
            ItemType.FOOTER.getValue()
        } else {
            itemType.getValue()
        }
    }

    override fun getItemCount(): Int = items.size + if (itemType != ItemType.HORIZONTAL) 1 else 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RealEstateViewHolder -> holder.bind(items[position], clickListener)
            is FooterVH -> holder.bind(footerClickListener)
        }

    }

    fun addItems(items: List<RealEstate>) = this.items.addAll(items)

    fun replaceItems(items: List<RealEstate>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    enum class ItemType(private val type: Int) {
        NONE(-1),
        VERTICAL(0),
        HORIZONTAL(1),
        FOOTER(2);

        fun getValue(): Int = type

        companion object {
            fun typeForValue(value: Int): ItemType? =
                ItemType.values().find { it.getValue() == value }
        }

    }

}

class FooterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val txtStartBuilding = itemView.findViewById<TextView>(R.id.txtStartBuilding)

    fun bind(clickListener: () -> Unit) {
        txtStartBuilding.setOnClickListener { clickListener() }
    }
}

class HorizontalListVH(itemView: View) : RealEstateViewHolder(itemView)

class VerticalListVH(itemView: View) : RealEstateViewHolder(itemView) {

    private val txtPrice = itemView.findViewById<TextView>(R.id.txtPrice)

    override fun bind(realEstate: RealEstate, clickListener: (RealEstate) -> Unit) {
        super.bind(realEstate, clickListener)
        txtPrice.text = realEstate.price
    }
}

abstract class RealEstateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val context = itemView.context

    val cardView = itemView.findViewById<View>(R.id.cardView)
    val imgHero = itemView.findViewById<ImageView>(R.id.imgHero)
    val txtAddress = itemView.findViewById<TextView>(R.id.txtAddress)
    val txtNeighborhood = itemView.findViewById<TextView>(R.id.txtAvailability)
    val txtBed = itemView.findViewById<TextView>(R.id.txtBed)
    val txtBath = itemView.findViewById<TextView>(R.id.txtBath)
    val txtArea = itemView.findViewById<TextView>(R.id.txtArea)

    open fun bind(realEstate: RealEstate, clickListener: (RealEstate) -> Unit) {
        GlideApp.with(context).load(realEstate.imageUrl).into(imgHero)

        txtAddress.text = realEstate.address
        txtNeighborhood.text = realEstate.neighborhood
        txtBed.text = context.getString(R.string.bedroom_count, realEstate.bedroomCount)
        txtBath.text = context.getString(R.string.bathroom_count, realEstate.bathroomCount)
        txtArea.text = context.getString(R.string.apt_area, realEstate.area)

        cardView.setOnClickListener { clickListener(realEstate) }
    }

}