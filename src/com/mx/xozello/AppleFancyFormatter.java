package com.mx.xozello;

import com.mx.xozello.model.Apple;

public class AppleFancyFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return "A " + (apple.getWeight() > 150 ? "heavy" : "light") + " " + apple.getColor() + " apple";
	}

}
