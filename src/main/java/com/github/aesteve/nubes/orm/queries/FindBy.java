package com.github.aesteve.nubes.orm.queries;

import java.util.HashMap;
import java.util.Map;

public class FindBy<T> {
	
	private Class<T> clazz;
	private Map<String, Object> restrictions;
	
	public FindBy(Class<T> clazz) {
		this.clazz = clazz;
		restrictions = new HashMap<>();
	}
	
	public FindBy(Class<T> clazz, String propertyName, Object propertyValue) {
		this(clazz);
		restrictions.put(propertyName, propertyValue);
	}
	
	public void addRestriction(String propertyName, Object propertyValue) {
		restrictions.put(propertyName, propertyValue);
	}
	
	public Class<T> getType() {
		return clazz;
	}
	
	public Map<String, Object> getRestrictions() {
		return restrictions;
	}
	
}
