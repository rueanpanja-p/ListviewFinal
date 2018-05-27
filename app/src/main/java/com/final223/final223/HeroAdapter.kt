package com.final223.final223

/**
 * Created by Heroter on 5/26/2018.
 */
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class HeroAdapter(private val context: Context,
                  private val dataSource: ArrayList<Heroes>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_hero, parent, false)
        val titleTextView = rowView.findViewById<TextView>(R.id.hero_list_title)
        val subtitleTextView = rowView.findViewById<TextView>(R.id.hero_list_detail)
        val thumbnailImageView = rowView.findViewById<ImageView>(R.id.hero_list_thumbnail)

        val hero = getItem(position) as Heroes
        titleTextView.text = hero.title
        subtitleTextView.text = hero.detail
        Picasso.with(context).load(hero.pic).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

        return rowView
    }
}