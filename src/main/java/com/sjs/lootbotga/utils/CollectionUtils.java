package com.sjs.lootbotga.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: StuartS
 * Date: 27/03/12
 * Time: 21:13
 */
public class CollectionUtils {
	public static <T>List<T> filter(Collection<T> collection, CollectionFilter<T> filter) {
		List<T> newList = new ArrayList<T>();
		for (T t : collection) {
			if (!filter.filterOut(t)) {
				newList.add(t);
			}
		}
		return newList;
	}
}
