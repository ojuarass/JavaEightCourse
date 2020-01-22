package com.mx.xozello.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.mx.xozello.model.Apple;

public class FilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple("green", 80), new Apple("green", 155), new Apple("red", 120));
		
		List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
		List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
		
		prettyPrintApple(heavyApples, new AppleFancyFormatter());
		prettyPrintApple(greenApples, new AppleFancyFormatter());
		
		List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
		});
		
		prettyPrintApple(redApples, new AppleFancyFormatter());
		
		List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
		prettyPrintApple(result, new AppleFancyFormatter());
		
	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}

		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory) {
			System.out.println(formatter.accept(apple));
		}
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if(p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}
