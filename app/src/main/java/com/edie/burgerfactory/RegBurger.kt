package com.edie.burgerfactory

/**
 * Created by ethanelshyeb on 1/11/18.
 */
class RegBurger: Burger {

   override fun getingredients() : List<Ingredient> {
        return listOf("bun","burger","burger","bun").map { Ingredient(it) }
    }
}