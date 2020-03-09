package com.mx.xozello.apple.streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mx.xozello.apple.streams.DishProvider;
import com.mx.xozello.model.Dish;

public class PartitioningExample {
	static List<Dish> menu = DishProvider.getMenu();

	public static void main(String[] args) {
		Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		System.out.println(partitionedMenu);
	}

}
