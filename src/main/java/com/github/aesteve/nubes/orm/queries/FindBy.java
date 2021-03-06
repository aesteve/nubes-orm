package com.github.aesteve.nubes.orm.queries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindBy<T> {

	private Class<T> clazz;
	private Map<String, Object> strictRestrictions;
	private Map<String, List<Object>> inRestrictions;
	private Function<T, Object> transformation;

	public FindBy(Class<T> clazz) {
		this.clazz = clazz;
		strictRestrictions = new HashMap<>();
		inRestrictions = new HashMap<>();
	}

	public FindBy(Class<T> clazz, String propertyName, Object propertyValue) {
		this(clazz);
		strictRestrictions.put(propertyName, propertyValue);
	}

	public void eq(String propertyName, Object propertyValue) {
		strictRestrictions.put(propertyName, propertyValue);
	}

	public void in(String propertyName, List<Object> possibleValues) {
		inRestrictions.put(propertyName, possibleValues);
	}

	public <Z> void in(String propertyName, List<Z> possibleValues, Function<Z, ?> getProperty) {
		inRestrictions.put(propertyName, possibleValues.stream().map(getProperty).collect(Collectors.toList()));
	}

	public void setTransform(Function<T, Object> transformation) {
		this.transformation = transformation;
	}

	public Class<T> getType() {
		return clazz;
	}

	public Map<String, Object> getStrictRestrictions() {
		return strictRestrictions;
	}

	public Map<String, List<Object>> getInRestrictions() {
		return inRestrictions;
	}

	public Object transform(T initial) {
		if (transformation == null) {
			return initial;
		}
		return transformation.apply(initial);
	}

}
