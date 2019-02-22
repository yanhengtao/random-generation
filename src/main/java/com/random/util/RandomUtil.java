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
		System.out.println("0��100֮����������" + val);
	}

	/**
	 * @description �������
	 * @param start ��ʼ�Ǳ�
	 * @param end   �����Ǳ�
	 * @return
	 */
	public static int random(int start, int end) {
		return (int) (Math.random() * (end - start) + start);
	}

	/**
	 * @description ���һ����Ŀ����
	 * @param start    ��ʼ�Ǳ�
	 * @param end      �����Ǳ�
	 * @param num      �����Ŀ
	 * @param isUnique �Ƿ�Ψһ
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
