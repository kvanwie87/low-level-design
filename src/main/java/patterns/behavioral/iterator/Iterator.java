package patterns.behavioral.iterator;

public interface Iterator<T> {
	public boolean hasNext();
	public T next();
}
