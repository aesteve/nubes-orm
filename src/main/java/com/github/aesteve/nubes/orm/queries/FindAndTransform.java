package com.github.aesteve.nubes.orm.queries;

import java.util.function.Function;

public class FindAndTransform<T, R> {
	public FindBy<T> findBy;
	public Function<T, R> transformation;

	public FindAndTransform(FindBy<T> findBy, Function<T, R> transformation) {
		this.findBy = findBy;
		this.transformation = transformation;
	}
}
