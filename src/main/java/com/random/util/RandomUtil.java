package com.random.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @description random util
 * @author yanhengtao
 *
 */
public class RandomUtil {

	public static void main(String[] args) {
		int val = random(0, 100);
		System.out.println("0与100之间的随机数：" + val);
	}

	/**
	 * @description 随机数字
	 * @param start 开始角标
	 * @param end   结束角标
	 * @return
	 */
	public static int random(int start, int end) {
		return (int) (Math.random() * (end - start) + start);
	}

	/**
	 * @description 随机一定数目数字
	 * @param start    开始角标
	 * @param end      结束角标
	 * @param num      随机数目
	 * @param isUnique 是否唯一
	 * @return
	 */
	public static List<Integer> randomMany(int start, int end, int num, boolean isUnique) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			int random = random(start, end);
			if (isUnique) {
				if (!list.contains(random)) {
					list.add(random);
				} else {
					i--;
				}
			} else {
				list.add(random);
			}
		}
		return list;
	}
}
