package com.example.myteamapphva.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myteamapphva.R
import com.example.myteamapphva.models.Game
import kotlinx.android.synthetic.main.item_program.view.*

class ResultAdapter(private val results: ArrayList<Game>) : RecyclerView.Adapter
    <ResultAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun databind(game: Game) {
            itemView.tvDate.text = game.date.toString()
            itemView.tvHomeTeam.text = game.homeTeam
            itemView.tvAwayTeam.text = game.awayTeam
            itemView.tvLine.text = "-"
            itemView.tvHomeScore.text = game.homeScore.toString()
            itemView.tvAwayScore.text = game.awayScore.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_program,
        parent, false))
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(results[position])
    }
}