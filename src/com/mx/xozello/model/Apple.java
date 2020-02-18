package com.mx.xozello.model;

public class Apple {
	String color;
	Integer weight;

	public Apple() {
	}

	public Apple(String color, int weight) {
		super();
		this.color = color;
		this.weight = weight;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
