package com.mx.xozello.apple.function;

import com.mx.xozello.model.Apple;

@FunctionalInterface
public interface ApplePredicate {
	boolean test(Apple apple);
}
