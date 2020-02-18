package com.mx.xozello.apple.predicate;

import com.mx.xozello.apple.function.ApplePredicate;
import com.mx.xozello.model.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}

}
