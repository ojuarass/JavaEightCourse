package com.mx.xozello.apple.streams.collectors;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

public class ReduceSummarizeExample {

	public static void main(String[] args) {
		List<Dish> menu = DishProvider.getMenu();
		long howManydishes = menu.stream().collect(Collectors.counting());
//		long howManydishes1 = menu.stream().count();

		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));

		int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));

		double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));

		IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(howManydishes);
		System.out.println(menuStatistics.getCount());
		System.out.println(mostCalorieDish);
		System.out.println(menuStatistics.getMax());
		System.out.println(totalCalories);
		System.out.println(menuStatistics.getSum());
		System.out.println(avgCalories);
		System.out.println(menuStatistics.getAverage());

		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println(shortMenu);

		// REDUCING
		int totalCalories1 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
//		int totalCalories1 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
//		int totalCalories1 = menu.stream().mapToInt(Dish::getCalories).sum();
		Optional<Dish> mostCalorieDish1 = menu.stream()
				.collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

	}

}
