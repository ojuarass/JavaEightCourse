package com.mx.xozello.apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.mx.xozello.apple.comparator.AppleComparator;
import com.mx.xozello.model.Apple;

import static java.util.Comparator.comparing;

public class CompareExample {

	public static void main(String[] args) {
		List<Apple> applesClass = sortWithClass();
		List<Apple> applesAnonymous = sortAnonymousClass();
		List<Apple> applesLambda = sortLambda();
		List<Apple> applesLambdaInfer = sortLambdaInfer();
		List<Apple> applesComparing = sortWithComparing();
		List<Apple> applesMethodReference = sortWithMethodReference();
		List<Apple> applesDecreasing = sortDecreasing();
		List<Apple> applesChaining = sortChainingComparators();
	}

	public static List<Apple> sortWithClass() {
		List<Apple> inventory = appleProvider();
		inventory.sort(new AppleComparator());
		return inventory;
	}

	public static List<Apple> sortAnonymousClass() {
		List<Apple> inventory = appleProvider();
		inventory.sort(new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		return inventory;
	}

	public static List<Apple> sortLambda() {
		List<Apple> inventory = appleProvider();
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		return inventory;
	}

	public static List<Apple> sortLambdaInfer() {
		List<Apple> inventory = appleProvider();
		inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		return inventory;
	}

	public static List<Apple> sortWithComparing() {
		List<Apple> inventory = appleProvider();
		// without importing comparing
		inventory.sort(Comparator.comparing((Apple a) -> a.getWeight()));
		// importing comparing
		inventory.sort(comparing((a) -> a.getWeight()));
		return inventory;
	}

	public static List<Apple> sortWithMethodReference() {
		List<Apple> inventory = appleProvider();
		inventory.sort(comparing(Apple::getWeight));
		return inventory;
	}
	
	public static List<Apple> sortDecreasing() {
		List<Apple> inventory = appleProvider();
		inventory.sort(comparing(Apple::getWeight).reversed());
		return inventory;
	}
	
	public static List<Apple> sortChainingComparators() {
		List<Apple> inventory = appleProvider();
		inventory.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor));
		return inventory;
	}

	public static List<Apple> appleProvider() {
		return Arrays.asList(new Apple("green", 80), new Apple("green", 155), new Apple("red", 120),
				new Apple("yellow", 160), new Apple("red", 105));
	}

}
