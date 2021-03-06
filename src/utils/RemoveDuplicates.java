
package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class RemoveDuplicates {

	private RemoveDuplicates() {}

	/**
	 * Removes all the duplicates from an array, and sets newly empty elements
	 * to null (these will be at the end of the array and the non-duplicates
	 * shifted left, e.g. {"a", "a", "b"} will go to {"a", "b", null}). The
	 * given array can contain null elements, {"a", null, "a", "b"} will become
	 * {"a", null, "b", null}
	 *
	 * @param a
	 *            The array to have duplicates removed from
	 */
	public static void removeDuplicates(Object[] a) {
		if (a == null) {
			throw new NullPointerException();
		}

		int count = 0;
		for (int i = 0; i < a.length - count; i++) {
			Object next = a[i];
			int p = i + 1;
			int oldCount = count;

			if (next != null) {
				for (int j = i + 1; j < a.length - oldCount; j++) {
					if (!next.equals(a[j])) {
						a[p++] = a[j];
					} else {
						count++;
						a[p] = a[j];
					}
				}
				for (; p < a.length - oldCount; p++) {
					a[p] = null;
				}
			} else {
				for (int j = i + 1; j < a.length - oldCount; j++) {
					if (a[j] != null) {
						a[p++] = a[j];
					} else {
						count++;
						a[p] = a[j];
					}
				}
				for (; p < a.length - oldCount; p++) {
					a[p] = null;
				}
			}

		}
	}

/**
	 * Removes all duplicates from a java collection according to the
	 * {@code remove} method of {@code java.util.Iterator#remove)
	 *
	 * @param c The collection to have its duplicate elements removed from
	 */
	public static void removeDuplicates(Collection<?> c) {
		ArrayList<Object> toRemove = new ArrayList<>();
		for (Iterator<?> it = c.iterator(); it.hasNext();) {
			Object a = it.next();
			int o = 0;
			for (Iterator<?> ti = c.iterator(); ti.hasNext();) {
				Object next = ti.next();
				if (next == null) {
					if (a == null) {
						o++;
						if (o > 1) {
							if (!toRemove.contains(next)) {
								toRemove.add(next);
							}
						}
					}
				} else {
					if (next.equals(a)) {
						o++;
						if (o > 1) {
							if (!toRemove.contains(next)) {
								toRemove.add(next);
							}
						}
					}
				}
			}
		}

		for (Object o : toRemove) {
			int count = 0;
			if (o == null) {
				for (Iterator<?> it = c.iterator(); it.hasNext();) {
					if (it.next() == null) {
						count++;
						if (count > 1) {
							it.remove();
						}
					}
				}
			} else {
				for (Iterator<?> it = c.iterator(); it.hasNext();) {
					if (o.equals(it.next())) {
						count++;
						if (count > 1) {
							it.remove();
						}
					}
				}
			}
		}
	}
}
