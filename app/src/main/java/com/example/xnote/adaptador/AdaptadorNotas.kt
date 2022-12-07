package com.example.xnote.adaptador

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.xnote.databinding.AdaptadorNotasBinding
import com.example.xnote.fragmentos.FGInicioDirections
import com.example.xnote.model.Note
import java.util.*


class AdaptadorNotas : RecyclerView.Adapter<AdaptadorNotas.NoteViewHolder>() {

    class NoteViewHolder(val itemBinding: AdaptadorNotasBinding) :
        RecyclerView.ViewHolder(itemBinding.root)


    private val differCallback =
        object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.noteBody == newItem.noteBody &&
                        oldItem.notetvDate == newItem.notetvDate &&
                        oldItem.noteSubTitle == newItem.noteSubTitle &&
                        oldItem.noteTitle == newItem.noteTitle
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            AdaptadorNotasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]

        holder.itemBinding.tvNoteTitle.text = currentNote.noteTitle
        holder.itemBinding.tvNoteSubTitle.text = currentNote.noteSubTitle
        holder.itemBinding.tvNoteDate.text = currentNote.notetvDate
        holder.itemBinding.tvNoteBody.text = currentNote.noteBody
        val random = Random()
        val color = Color.BLUE
        holder.itemBinding.ibColor.setBackgroundColor(color)

        holder.itemView.setOnClickListener { view ->

            val direction = FGInicioDirections
                .actionHomeFragmentToUpdateNoteFragment(currentNote)
            view.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}