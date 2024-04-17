package com.example.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//import androidx.recyclerview.widget.RecyclerView.ViewHolder


class UsernameListAdapter : ListAdapter<Username,UsernameListAdapter.UsernameViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : UsernameViewHolder {
        return  UsernameViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder : UsernameViewHolder , position: Int) {
        val current = getItem(position)
        holder.bind(current.username)
    }

    class UsernameViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val usernameItemView : TextView = itemView.findViewById(R.id.textView)

        fun bind(text : String?) {
            usernameItemView.text = text
        }

        companion object {
            fun create(parent : ViewGroup) : UsernameViewHolder {
                val view : View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recylerview_item , parent , false)
                return UsernameViewHolder(view)
            }
        }
    }


       class WordsComparator : DiffUtil.ItemCallback<Username>() {
            override fun areItemsTheSame(oldItem : Username , newItem : Username) : Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem : Username , newItem : Username) : Boolean {
                return oldItem.username == newItem.username
            }
        }
    }

