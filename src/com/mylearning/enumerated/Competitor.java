package com.mylearning.enumerated;

public interface Competitor<T extends Competitor<T>> {
	Outcome compete(T competitor);
}
