package com.mx.xozello.apple.predicate;

import com.mx.xozello.apple.function.ApplePredicate;
import com.mx.xozello.model.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}

}
