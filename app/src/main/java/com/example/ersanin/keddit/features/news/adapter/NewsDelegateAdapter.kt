package com.example.ersanin.keddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.ersanin.keddit.R
import com.example.ersanin.keddit.common.RedditNewsItem
import com.example.ersanin.keddit.common.adapter.ViewType
import com.example.ersanin.keddit.common.adapter.ViewTypeDelegateAdapter
import com.example.ersanin.keddit.common.extensions.getFriendlyTime
import com.example.ersanin.keddit.common.extensions.inflate
import com.example.ersanin.keddit.common.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by Ersanin on 23.06.2016.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}