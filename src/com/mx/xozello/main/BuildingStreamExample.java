package com.mx.xozello.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreamExample {

	public static void main(String[] args) {
		getStreamsFromValues();
		getStreamsFromArrays();
		getStreamsFromFunctions();
	}

	public static void getStreamsFromValues() {
		Stream<String> stringStream = Stream.of("Java", "8", "Lambdas", "in", "Action");
		stringStream.map(String::toUpperCase).forEach(System.out::println);

		Stream<String> stringEmptyStream = Stream.empty();
	}

	public static void getStreamsFromArrays() {
		int[] numbers = { 1, 2, 3, 4, 5 };
		int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);
	}

	public static void getStreamsFromFiles() {
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		} catch (IOException e) {
		}
		System.out.println(uniqueWords);
	}

	public static void getStreamsFromFunctions() {
		// Creating infinite streams
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

		// fibonacci series with iterate
		Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] }).limit(10)
//				.forEach(n -> System.out.println("(" + n[0] + "," + n[1] + ")"));
				.map(n -> n[0]).forEach(System.out::println);
		
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		
		// fibonacci series with generate
		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;
			
			@Override
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
		
		IntStream.generate(fib).limit(10).forEach(System.out::println);
	}
}
