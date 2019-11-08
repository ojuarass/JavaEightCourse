package com.mx.xozello;

import com.mx.xozello.model.Apple;

public class AppleSimpleFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return "An apple of " + apple.getWeight() + "g";
	}

}
