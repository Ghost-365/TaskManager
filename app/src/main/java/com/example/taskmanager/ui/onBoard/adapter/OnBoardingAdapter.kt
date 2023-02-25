package com.example.taskmanager.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager.databinding.ItemOnBoardingBinding
import com.example.taskmanager.model.OnBoard
import com.example.taskmanager.utils.loadImage

class OnBoardingAdapter(private val onStartClick:() -> Unit) : androidx.recyclerview.widget.RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = arrayListOf<OnBoard>(
        OnBoard("Test 1",
            "Description 1",
            "https://img.freepik.com/free-vector/hand-drawn-business-planning-with-task-list_23-2149164275.jpg"),

        OnBoard("Test 2",
            "Description 2",
            "https://img.freepik.com/free-vector/hand-drawn-business-planning-with-task-list_23-2149164275.jpg"),

        OnBoard("Test 3",
            "Description 3",
            "https://img.freepik.com/free-vector/hand-drawn-business-planning-with-task-list_23-2149164275.jpg"),
    )



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount() = data.size

    inner class OnBoardingViewHolder(private val binding:ItemOnBoardingBinding):
        ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {
            binding.btnStart.isVisible = adapterPosition == 2
            binding.btnSkip.isVisible = adapterPosition != 2
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
            binding.btnSkip.setOnClickListener {
                onStartClick()
            }
            binding.title.text= onBoard.title
            binding.description.text=onBoard.desc
            binding.ivBoard.loadImage(onBoard.image.toString())
        }

    }

}