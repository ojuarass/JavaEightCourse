package com.mx.xozello.main;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MappingExample {

	public static void main(String[] args) {
		printFlatteningStream();
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
