package com.example.movie_info.Reycler_Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.movie_info.Model.Movies
import com.example.movie_info.R
import com.example.movie_info.viewmodels.MainViewModel

class Adapter2(
    private val mainViewModel: MainViewModel,


    ) : RecyclerView.Adapter<Adapter2.ViewHolder>() {

    private var list= mutableListOf<Movies>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.movieview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie=list[position];
        holder.moviename.setText(movie.Title)
        holder.moviecast.setText(movie.Cast)
        holder.movieyear.setText(movie.Year)
        holder.movieruntime.setText(movie.Runtime)
//        holder.delete.setOnClickListener {
//            mainViewModel.deletemovie(movie.IMDBID)
//            list.removeAt(holder.adapterPosition)
//            notifyItemRemoved(holder.adapterPosition)
//        }









    }

    private fun apicall(size: Int, layoutPosition: Int) {

        if (size-1==layoutPosition){
            mainViewModel.getmoviee("2")
        }

    }






    fun setdata(data: List<Movies>){
        list.apply {
       
            addAll(data)

        }
    }




    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val moviename= itemview.findViewById<TextView>(R.id.moviename)
        val moviecast= itemview.findViewById<TextView>(R.id.moviecast)
        val movieyear= itemview.findViewById<TextView>(R.id.movieyear)
        val movieruntime= itemview.findViewById<TextView>(R.id.movietime)
//        val delete=itemview.findViewById<ImageView>(R.id.delete)



    }
}