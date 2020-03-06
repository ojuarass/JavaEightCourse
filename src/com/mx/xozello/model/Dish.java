package com.mx.xozello.model;

public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dish [name=");
		builder.append(name);
		builder.append(", vegetarian=");
		builder.append(vegetarian);
		builder.append(", calories=");
		builder.append(calories);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

	public enum Type {
		MEAT, FISH, OTHER
	}
}
