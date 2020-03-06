package com.mx.xozello.main;

import java.util.List;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;

public class FilteringExample {

	public static void main(String args[]) {
		System.out.println("LOW CALORIC DISHES");
		List<String> lowcaloricalDishes = getLowCaloricDishes();
		lowcaloricalDishes.forEach(a -> System.out.println(a));

		System.out.println("THREE HIGH CALORIC DISHES");
		List<String> threeHighCaloricDishes = getThreeHighCaloricDishes();
		threeHighCaloricDishes.forEach(a -> System.out.println(a));

		System.out.println("VEGETARIAN DISHES");
		List<Dish> vegetarianDishes = getVegetarianDishes();
		vegetarianDishes.forEach(a -> System.out.println(a));

		System.out.println("EVEN NUMBERS");
		printDistinctEvenNumbers();

	}

	public static List<String> getLowCaloricDishes() {
		return DishProvider.getMenu().stream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories))
				.map(Dish::getName).collect(toList());
	}

	public static List<String> getThreeHighCaloricDishes() {
		return DishProvider.getMenu().stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3)
				.collect(toList());
	}

	// filtering with a predicate
	public static List<Dish> getVegetarianDishes() {
		return DishProvider.getMenu().stream().filter(Dish::isVegetarian).collect(toList());
	}

	/*
	 * FILTERING AND SLICING Filtering unique elements
	 */
	public static void printDistinctEvenNumbers() {
		List<Integer> numberList = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 7, 10);
		numberList.stream().filter(x -> x % 2 == 0).distinct().forEach(System.out::println);
	}

	// Filtering an truncating
	public static List<Dish> getHighCaloricLimitDishes() {
		return DishProvider.getMenu().stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());
	}

	// Filtering and skipping
	public static List<Dish> getHighCaloricDiscardDishes() {
		return DishProvider.getMenu().stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
	}

}
