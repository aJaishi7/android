package com.college.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.college.recyclerview.ActorDetailActivity
import com.college.recyclerview.R
import com.college.recyclerview.model.Actor
import de.hdodenhof.circleimageview.CircleImageView

class ActorAdapter(
    val lstActor: ArrayList<Actor>,
    val context: Context
) : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProfile: CircleImageView
        val tvName: TextView
        val tvAddress: TextView
        val tvSalary: TextView

        init {
            imgProfile = view.findViewById(R.id.imgProfile);
            tvName = view.findViewById(R.id.tvName);
            tvAddress = view.findViewById(R.id.tvAddress);
            tvSalary = view.findViewById(R.id.tvSalary);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.mero_actor_layout, parent, false);
        return ActorViewHolder(view);
    }

    override fun getItemCount(): Int {
        return lstActor.size;
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = lstActor[position];
        holder.tvName.text = actor.actorName;
        holder.tvAddress.text = actor.actorAddredss;
        holder.tvSalary.text = actor.actorSalary.toString();

        holder.imgProfile.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//                Toast.makeText(context, "I'm ${actor.actorName}", Toast.LENGTH_SHORT).show();
                val intent = Intent(context, ActorDetailActivity::class.java);
                intent.putExtra("actor",actor);
                context.startActivity(intent);

            }

        })
        ;
        Glide.with(context).load(actor.actorImage).into(holder.imgProfile);
    }

}