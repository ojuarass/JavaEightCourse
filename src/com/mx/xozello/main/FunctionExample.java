package com.mx.xozello.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.mx.xozello.model.Letter;

public class FunctionExample {

	public static void main(String[] args) {

		List<Integer> list = map(Arrays.asList("Lambdas", "in", "action"), (String s) -> s.length());
		for (Integer integer : list) {
			System.out.println(integer);
		}

		// Composing Functions
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		// g(f(x))
		Function<Integer, Integer> h = f.andThen(g);
		System.out.println("Composing  g(f(x)) function result: " + h.apply(2));
		// f(g(x))
		Function<Integer, Integer> i = f.compose(g);
		System.out.println("Composing  f(g(x)) function result: " + i.apply(2));

		// Other Example
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);

	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}
}
