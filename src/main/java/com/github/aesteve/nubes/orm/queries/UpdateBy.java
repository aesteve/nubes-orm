package com.github.aesteve.nubes.orm.queries;

public class UpdateBy<T> {

	public FindBy<T> findBy;
	public T updated;

	@SuppressWarnings("unchecked")
	public UpdateBy(T updated, String critName, Object critValue) {
		this.updated = updated;
		findBy = (FindBy<T>) new FindBy<>(updated.getClass());
		findBy.eq(critName, critValue);
	}

	public Object transform(T initial) {
		return findBy.transform(initial);
	}
}
