package com.mx.xozello.apple.predicate;

import com.mx.xozello.apple.function.ApplePredicate;
import com.mx.xozello.model.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "red".equals(apple.getColor()) && apple.getWeight() > 150;
	}

}
