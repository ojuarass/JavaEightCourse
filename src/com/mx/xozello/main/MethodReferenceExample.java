package com.mx.xozello.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import com.mx.xozello.apple.function.TriFunction;
import com.mx.xozello.model.Apple;
import com.mx.xozello.model.Color;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		List<Integer> weights = Arrays.asList(7, 3, 4, 10);
		List<Apple> apples = map(weights, Apple::new);
		System.out.println(apples);
		
		TriFunction<Integer, Integer, Integer, Color> colorFactory = Color::new;
		Color color = colorFactory.apply(4, 12, 24);
		System.out.println(color);
		
	}	
	
	public static List<Apple> map(List<Integer> list, BiFunction<String, Integer, Apple> f){
		List<Apple> result = new ArrayList<>();
		for (Integer e : list) {
			result.add(f.apply("red", e));
		}
		return result;
	}
	
	
}
