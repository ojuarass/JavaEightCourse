package com.mx.xozello.apple.streams.collectors;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

public class GroupingExample {
	static List<Dish> menu = DishProvider.getMenu();

	public static void main(String[] args) {
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		System.out.println(dishesByType);

		printGrouping();
		printMultilevelGrouping();
		printTypesCount();
		printMostCaloricByType();
		printTotalCaloriesByType();
		printCaloricLevelsByType();
	}

	public static void printGrouping() {
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(Collectors.groupingBy(dish -> {
			if (dish.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}));
		System.out.println(dishesByCaloricLevel);
	}

	public static void printMultilevelGrouping() {
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				})));

		System.out.println(dishesByTypeCaloricLevel);
	}

	public static void printTypesCount() {
		Map<Dish.Type, Long> typesCount = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		System.out.println(typesCount);
	}

	public static void printMostCaloricByType() {
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(
				Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println(mostCaloricByType);

		Map<Dish.Type, Dish> mostCaloricByType1 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricByType1);
	}

	public static void printTotalCaloriesByType() {
		Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
		System.out.println(totalCaloriesByType);
	}

	public static void printCaloricLevelsByType() {
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}, Collectors.toSet())));
		System.out.println(caloricLevelsByType);

		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType1 = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}, Collectors.toCollection(HashSet::new))));
		System.out.println(caloricLevelsByType1);
	}

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}
}
