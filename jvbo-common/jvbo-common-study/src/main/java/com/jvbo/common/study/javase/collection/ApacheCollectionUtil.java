package com.jvbo.common.study.javase.collection;

import com.jvbo.common.study.javase.collection.model.CollectionModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.sql.Timestamp;
import java.util.*;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/10
 */
public class ApacheCollectionUtil {
	public static void main(String[] args) {
		/*String[] arrayA = new String[] { "a", "b", "c" };
		String[] arrayB = new String[] { "a", "b", "d" };
		List<String> a = Arrays.asList(arrayA);
		List<String> b = Arrays.asList(arrayB);
		//并集
		Collection<String> union = CollectionUtils.union(a, b);
		//交集
		Collection<String> intersection = CollectionUtils.intersection(a, b);
		//交集的补集
		Collection<String> disjunction = CollectionUtils.disjunction(a, b);
		//集合相减
		Collection<String> subtract = CollectionUtils.subtract(b, a);
		Collections.sort((List<String>) union);
		Collections.sort((List<String>) intersection);
		Collections.sort((List<String>) disjunction);
		Collections.sort((List<String>) subtract);
		System.out.println("A: " + ArrayUtils.toString(a.toArray()));
		System.out.println("B: " + ArrayUtils.toString(b.toArray()));
		System.out.println("--------------------------------------------");
		System.out.println("并集    Union(A, B): " + ArrayUtils.toString(union.toArray()));
		System.out.println("交集 Intersection(A, B): " + ArrayUtils.toString(intersection.toArray()));
		System.out.println("交集的补集      Disjunction(A, B): " + ArrayUtils.toString(disjunction.toArray()));
		System.out.println("集合相减 Subtract(A, B): " + ArrayUtils.toString(subtract.toArray()));*/

		List<CollectionModel> a = new ArrayList<>();
		CollectionModel collectionModel = null;
		for (int i = 1; i < 4; i++) {
			collectionModel = new CollectionModel();
			/*collectionModel.setId(Long.valueOf(i-1));
			collectionModel.setIsDeleted(i);
			collectionModel.setTimestamp(new Timestamp(new Date().getTime()));*/
			collectionModel.setName(String.valueOf(i-1));
			collectionModel.setBase("0" + (i - 1));
			collectionModel.setQuote("1" + (i - 1));
		}

		List<CollectionModel> b = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			collectionModel = new CollectionModel();
			collectionModel.setName(String.valueOf(i + 1));
			collectionModel.setBase("0" + (i + 1));
			collectionModel.setQuote("1" + (i + 1));
		}

		Collection<String> subtract = CollectionUtils.subtract(b, a);
		Collections.sort((List<String>) subtract);

		System.out.println("集合相减 Subtract(A, B): " + ArrayUtils.toString(subtract.toArray()));

		System.out.println(Long.valueOf("12141525126152615").equals(Long.valueOf("12141525126152615")));
	}
}
