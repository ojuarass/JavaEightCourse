package com.mx.xozello.main;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

public class ReducingExample {
	
	public static void main(String[] args) {
		reduceNumbers();
		printMaximumMinimum();
		countDishes();
	}
	
	public static void reduceNumbers() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		
//		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		int sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println(sum);
		
		int product = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println(product);
		
		// case when the strean contains no elements
		Optional<Integer> sumOptional = numbers.stream().reduce((a, b) -> (a + b));
	}
	
	public static void printMaximumMinimum() {
		List<Integer> numbers = Arrays.asList(8, 2, 43, 14);
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println(max);
		
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		System.out.println(min);
	}
	
	public static void countDishes() {
		List<Dish> dishes = DishProvider.getMenu();
		int count = dishes.stream().map(d -> 1).reduce(0,  (a, b) -> a + b);
		System.out.println(count);
	}
}
