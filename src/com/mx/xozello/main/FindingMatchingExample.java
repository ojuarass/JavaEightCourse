package com.mx.xozello.main;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

public class FindingMatchingExample {

	public static void main(String[] args) {
		printFindAndMatch();
		printFirstAndAny();
	}

	/*
	 * FINDING AND MATCHING short-circuiting evaluation
	 */
	public static void printFindAndMatch() {
		List<Dish> menu = DishProvider.getMenu();
		if (menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly");
		}

		if (menu.stream().allMatch(d -> d.getCalories() < 1000)) {
			System.out.println("All is healthy");
		}

		if (menu.stream().noneMatch(d -> d.getCalories() > 1000)) {
			System.out.println("All is healthy too");
		}
	}

	public static void printFirstAndAny() {
		List<Dish> menu = DishProvider.getMenu();
		Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
		System.out.println(dish);

		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		Optional<Integer> firstSquareDivisibleBythree = someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0)
				.findFirst();
		System.out.println(firstSquareDivisibleBythree);
	}
}
