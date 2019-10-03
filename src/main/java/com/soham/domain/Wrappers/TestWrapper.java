package com.soham.domain.Wrappers;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.UnaryOperator;

@FunctionalInterface
interface Consumer<T> {
	void accept(T t) throws Exception;

	default Consumer<T> andThen(Consumer<? super T> after) {
		Objects.requireNonNull(after);
		return (T t) -> {
			accept(t);
			after.accept(t);
		};
	}
}

interface ListWrapper<T> extends List<T> {
	public void forEachOne(Consumer<? super T> action) throws Exception;
}

class ArrayWrappers {

	@SafeVarargs
	public static <T> ListWrapper<T> asList(T... a) {
		return new ArrayList<>(a);
	}

	public static class ArrayList<E> extends AbstractList<E>
			implements ListWrapper<E>, RandomAccess, java.io.Serializable {
		private static final long serialVersionUID = -2764017481108945198L;

		private final E[] a;

		ArrayList(E[] array) {
			a = Objects.requireNonNull(array);
		}

		@Override
		public int size() {
			return a.length;
		}

		@Override
		public Object[] toArray() {
			return a.clone();
		}

		@Override
		@SuppressWarnings("unchecked")
		public <T> T[] toArray(T[] a) {
			int size = size();
			if (a.length < size)
				return Arrays.copyOf(this.a, size, (Class<? extends T[]>) a.getClass());
			System.arraycopy(this.a, 0, a, 0, size);
			if (a.length > size)
				a[size] = null;
			return a;
		}

		@Override
		public E get(int index) {
			return a[index];
		}

		@Override
		public E set(int index, E element) {
			E oldValue = a[index];
			a[index] = element;
			return oldValue;
		}

		@Override
		public int indexOf(Object o) {
			E[] a = this.a;
			if (o == null) {
				for (int i = 0; i < a.length; i++)
					if (a[i] == null)
						return i;
			} else {
				for (int i = 0; i < a.length; i++)
					if (o.equals(a[i]))
						return i;
			}
			return -1;
		}

		@Override
		public boolean contains(Object o) {
			return indexOf(o) != -1;
		}

		@Override
		public Spliterator<E> spliterator() {
			return Spliterators.spliterator(a, Spliterator.ORDERED);
		}

		@Override
		public void replaceAll(UnaryOperator<E> operator) {
			Objects.requireNonNull(operator);
			E[] a = this.a;
			for (int i = 0; i < a.length; i++) {
				a[i] = operator.apply(a[i]);
			}
		}

		@Override
		public void sort(Comparator<? super E> c) {
			Arrays.sort(a, c);
		}

		public void forEachOne(Consumer<? super E> action) throws Exception {
			Objects.requireNonNull(action);
			for (E t : this) {
				action.accept(t);
			}
		}

	}
}

public class TestWrapper {

	public static void main(String[] args) throws Exception {

		ListWrapper<Integer> x = ArrayWrappers.asList(1, 2, 3, 4);
		ListWrapper<Integer> y = ArrayWrappers.asList(1, 2, 0, 4);
		x.forEachOne(TestWrapper::print);
		y.forEachOne(TestWrapper::print);
	}

	private static void print(int x) throws Exception {

		if (x == 0) {
			throw new Exception("printing zero");
		}
		System.out.println(x);
	}

}
