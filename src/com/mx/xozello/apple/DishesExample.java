package com.mx.xozello.apple;

import java.util.List;
import java.util.stream.Stream;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;

public class DishesExample {

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

		printFlatteningStream();
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

	/*
	 * MAPPING
	 */
	public static List<Integer> getWordLengths() {
		List<String> words = Arrays.asList("Java 8", "Lambdas", "in", "action");
		return words.stream().map(String::length).collect(toList());
	}

	// Flattening streams
	public static void printFlatteningStream() {
		// Wrong
		String[] words = { "hello", "world" };
		Stream<String> wordsArrayStream = Arrays.stream(words);
		List<String[]> wordList = wordsArrayStream.map(s -> s.split("")).distinct().collect(toList());
		wordList.forEach(a -> System.out.println(a));

		// Wrong
		String[] otherWords = { "Goodbye", "World" };
		Stream<String> streamOfWords = Arrays.stream(otherWords);
		List<Stream<String>> otherWordList = streamOfWords.map(word -> word.split("")).map(Arrays::stream).distinct()
				.collect(toList());
		otherWordList.forEach(System.out::println);

		// OK
		Stream<String> finalStream = Arrays.stream(words);
		List<String> finalList = finalStream.map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(toList());
		System.out.println(finalList);

		// Quiz
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream().flatMap(x -> numbers2.stream().map(y -> new int[] { x, y }))
				.collect(toList());
		System.out.println(pairs);
	}

}
