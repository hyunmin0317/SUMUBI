package com.example.sumubi

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SubjectAdapter(
    var subjectList: ArrayList<Subject>,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<SubjectAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val prof: TextView

        init {
            name = itemView.findViewById(R.id.name)
            prof = itemView.findViewById(R.id.prof)

            itemView.findViewById<TextView>(R.id.name).setOnClickListener {
                val intent = Intent(activity, SubjectActivity::class.java)
                val subject = subjectList.get(adapterPosition)
                intent.putExtra("name", subject.name)
                intent.putExtra("prof", subject.prof)
                intent.putExtra("code", subject.code)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.subject_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(subjectList.get(position).name)
        holder.prof.setText(subjectList.get(position).prof)
    }
}