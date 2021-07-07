package main.objectifiers.iterators;

public abstract class Iterator<T> {
	public abstract T first();
	public abstract T next();
	public abstract boolean isDone();
	public abstract boolean hasNext();
	public abstract T currentItem();
}
