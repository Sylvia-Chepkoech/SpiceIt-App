
package com.example.spiceit_app.models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class RandomCocktails implements Serializable {

    @SerializedName("drinks")
    @Expose
    private List<Drink> drinks = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RandomCocktails() {
    }

    /**
     * 
     * @param drinks
     */
    public RandomCocktails(List<Drink> drinks) {
        super();
        this.drinks = drinks;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

}
