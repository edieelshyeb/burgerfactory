package com.edie.burgerfactory

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_burgers.*

class BurgersActivity : AppCompatActivity() {

    val burgers = mutableListOf<String>()
    lateinit var burgersAdapter: ArrayAdapter<String>
    var clock = 0

    fun addIngredient(name: String) {
        burgers.add(name)
        burgersAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burgers)
        burgersAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, burgers)
        burgerlist.setOnItemClickListener { parent, view, position, id ->
            burgers.removeAt(position)
            burgersAdapter.notifyDataSetChanged()
        }
        burgerlist.adapter = burgersAdapter
        tomatoButton.setOnClickListener {
            Toast.makeText(this, "tomato succesfully added", Toast.LENGTH_SHORT).show()
            addIngredient("tomato")
        }
        lettuceButton.setOnClickListener {
            Toast.makeText(this, "lettuce succesfully added", Toast.LENGTH_SHORT).show()
            addIngredient("lettuce")
        }
        bunButton.setOnClickListener {
            Toast.makeText(this, "bun succesfully added", Toast.LENGTH_SHORT).show()
            addIngredient("bun")
        }
        burgerButton.setOnClickListener {
            Toast.makeText(this, "burger succesfully added", Toast.LENGTH_SHORT).show()
            addIngredient("burger")
        }
        challangeButton.setOnClickListener {
            clock = 60
        challengeList.text = RegBurger().getingredients()
           clockburger()
        }
    }

    fun clockburger() {
        Handler().postDelayed({
            clock-=1
            timerburger.text=clock.toString()
            if(clock > 0) clockburger()
        },1000)

    }

}
