package com.sinuke.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DesignFoodRatingSystem {

    public static class FoodRatings {

        private final Map<String, String> foods;
        private final Map<String, Food> foodMap;
        private final Map<String, SortedSet<Food>> cuisines;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            this.cuisines = new HashMap<>(n);
            this.foods = new HashMap<>(n);
            this.foodMap = new HashMap<>(n);

            for (int i = 0; i < n; i++) {
                var food = new Food(foods[i], ratings[i]);

                this.foods.putIfAbsent(foods[i], cuisines[i]);
                this.cuisines.putIfAbsent(cuisines[i], new TreeSet<>(Comparator.<Food>comparingInt(f -> f.rating).reversed().thenComparing(f -> f.name)));

                this.cuisines.get(cuisines[i]).add(food);
                this.foodMap.put(foods[i], food);
            }
        }

        public void changeRating(String food, int newRating) {
            var f = foodMap.get(food);
            cuisines.get(foods.get(food)).remove(f);
            f.rating = newRating;
            cuisines.get(foods.get(food)).add(f);
        }

        public String highestRated(String cuisine) {
            return cuisines.get(cuisine).first().name;
        }

        private static class Food {
            String name;
            int rating;

            Food(String name, int rating) {
                this.name = name;
                this.rating = rating;
            }
        }

    }

}
