package com.college.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.college.recyclerview.model.Actor
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class ActorDetailActivity : AppCompatActivity() {

    private lateinit var imgProfile: CircleImageView;
    private lateinit var tvName: TextView;
    private lateinit var tvAddress: TextView;
    private lateinit var tvSalary: TextView;
    private lateinit var tvActorId: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_detail)

        imgProfile = findViewById(R.id.imgProfile);
        tvName = findViewById(R.id.tvName);
        tvActorId = findViewById(R.id.tvActorId);
        tvAddress = findViewById(R.id.tvAddress);
        tvSalary = findViewById(R.id.tvSalary);


        val intent = intent.getParcelableExtra<Actor>("actor") as Actor;
        if (intent != null) {
            val id = intent.actorId;
            val name = intent.actorName;
            val address = intent.actorAddredss;
            val salary = intent.actorSalary;
            val image = intent.actorImage;

            tvActorId.text = id.toString();
            tvName.text = name.toString();
            tvAddress.text = address.toString();
            tvSalary.text = salary.toString();

            Glide.with(this).load(image).into(imgProfile);

        }

    }
}