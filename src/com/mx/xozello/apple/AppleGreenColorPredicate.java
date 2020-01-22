package com.mx.xozello.apple;

import com.mx.xozello.model.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}

}