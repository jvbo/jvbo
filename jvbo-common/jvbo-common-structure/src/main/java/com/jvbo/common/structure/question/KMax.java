package com.jvbo.common.structure.question;

import java.util.Arrays;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
public class KMax {
	/**
	 * 选择问题:设有一组N个数而要确定其中第k个最大者;
	 */
	public static void main(String[] args) {
		int[] originArr = new int[]{8, 5, 10, 7, 6, 1, 3, 2, 9, 4};
		System.out.println(bubbleSort(5, originArr));
		System.out.println(readInSort(5, originArr));
	}

	/**
	 * 递减排序并返回第k个值
	 * @param k
	 * @param originArr
	 * @return
	 */
	private static int bubbleSort(int k, int[] originArr){
		int length = originArr.length;
		// 冒泡排序
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - 1; j++) {
				if(originArr[j] < originArr[j + 1]){
					int temp = originArr[j];
					originArr[j] = originArr[j + 1];
					originArr[j + 1] = temp;
				}
			}
		}
		return originArr[k - 1];
	}

	/**
	 * 先读入前k个元素并递减排序,再用后面的新元素与数组元素对比根据比较结果将新元素放入数组中正确位置或舍弃,
	 * 结束后返回k元素
	 * @param k
	 * @param originArr
	 * @return
	 */
	public static int readInSort(int k, int[] originArr){
		int[] kArr = new int[k];
		int kArrlength = kArr.length;
		for (int i = 0; i < kArrlength; i++) {
			kArr[i] = originArr[i];
		}
		// 选择排序实现新数组的递减排序
		for (int i = 0; i < kArrlength; i++) {
			for (int j = i; j < kArrlength; j++) {
				if(kArr[i] < kArr[j]){
					int temp = kArr[i];
					kArr[i] = kArr[j];
					kArr[j] = temp;
				}
			}
		}
		int originArrLength = originArr.length;
		// 从下标k开始,读取后面的元素
		for (int i = k; i < originArrLength; i++) {
			int newElement = originArr[i];
			// 新元素比kArr中的最小元素大才能进一步比较
			if(newElement > kArr[k - 1]){
				for (int j = 0; j < originArrLength - 1; j++) {
					// 如果新元素大小在两个元素之间,插入新元素,插入位置后的元素索引后移1
					if(kArr[j] > newElement && newElement > kArr[j + 1]){
						if(k > j + 1){
							// 数组j+1索引后面的后一个元素为前一个元素的值
							kArr[j] = kArr[j - 1];
						}
						// 新元素插入
						kArr[j + 1] = newElement;
					}
				}
			}
		}
		return kArr[k - 1];
	}


}
