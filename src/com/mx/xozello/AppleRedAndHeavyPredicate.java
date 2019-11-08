package com.mx.xozello;

import com.mx.xozello.model.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "red".equals(apple.getColor()) && apple.getWeight() > 150;
	}

}
