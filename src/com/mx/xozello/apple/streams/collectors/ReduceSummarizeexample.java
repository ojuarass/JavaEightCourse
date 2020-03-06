package com.mx.xozello.apple.streams.collectors;

import java.util.List;
import java.util.stream.Collectors;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

public class ReduceSummarizeexample {

	public static void main(String[] args) {
		List<Dish> menu = DishProvider.getMenu();
		long howManydishes = menu.stream().collect(Collectors.counting());
//		long howManydishes1 = menu.stream().count();

	}

}
