package com.mx.xozello.main;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

public class NumericStreamExample {

	public static void main(String[] args) {
		List<Dish> menu = DishProvider.getMenu();
		System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());

		OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
		System.out.println(maxCalories.orElse(1));

		IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.count());

		// Pythagorean triples
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));

		pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

		// Better Pythagorean triples
		Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) }).filter(t -> t[2] % 1 == 0));
		pythagoreanTriples2.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
	}
}
