package com.geektech.taskapp.ui.onBoarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.taskapp.databinding.ItemOnboardingBinding
import com.geektech.taskapp.model.OnBoard
import com.geektech.taskapp.util.loadImage

class OnBoardingAdapter(private val onClick: () -> Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val onBoardData  = arrayListOf(
        OnBoard("Mentored by professional", "Guided by people who professional, will add more" +
                " knowledge ", "https://cdn-icons-png.flaticon.com/512/9186/9186499.png"),
        OnBoard("Practice everywhere","Do not think that learning can be done at school","https://cdn-icons-png.flaticon.com/512/4334/4334822.png"), OnBoard("Mentored by professional", "Guided by people who professional, will add more" +
                " knowledge ", "https://cdn-icons-png.flaticon.com/512/9186/9186499.png")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(onBoardData[position])
    }

    override fun getItemCount(): Int {
        return onBoardData.size
    }



    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) : ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
            binding.ivImg.loadImage(onBoard.image.toString())
            binding.btn.isVisible = adapterPosition == onBoardData.lastIndex
            binding.btn.setOnClickListener{
                onClick()
            }
        }
    }
}