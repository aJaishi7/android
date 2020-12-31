package com.college.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.college.recyclerview.adapter.ActorAdapter
import com.college.recyclerview.model.Actor

class MainActivity : AppCompatActivity() {

    private lateinit var actorRecycler: RecyclerView;
    private var lstActor = arrayListOf<Actor>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actorRecycler = findViewById(R.id.actorRecycle);

        loadActor();
        val adapter = ActorAdapter(lstActor, this);
        actorRecycler.layoutManager = LinearLayoutManager(this);
        actorRecycler.adapter = adapter;
    }

    private fun loadActor() {
        lstActor.add(
            Actor(
                1,
                "Rajesh Hamal",
                "https://myrepublica.nagariknetwork.com/uploads/media/RajeshHamal.jpg",
                "Kathmandu Nepal",
                200000F
            )
        );


        lstActor.add(
            Actor(
                2,
                "Salman Khan",
                "https://www.gstatic.com/tv/thumb/persons/173429/173429_v9_bb.jpg",
                "India",
                20000000F
            )
        );


        lstActor.add(
            Actor(
                3,
                "Arjun Jaishi",
                "https://avatars2.githubusercontent.com/u/47152775?s=400&u=ec94263ed9d5deba75902137e6b6e660c24c5a79&v=4",
                "Nepal",
                20000000F
            )
        );

    }
}