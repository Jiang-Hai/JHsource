package com.jianghai;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * ���ڲ���java8 ����ʽ���Lambda���
 * @author jiang-hai
 *
 */
public class LambdaByJ {
	
	public static void main(String[] args){
		
		TestEntry a = new TestEntry();
		TestEntry b = new TestEntry();
		TestEntry c = new TestEntry();
		a.setId(10);
		a.setName("a");
		b.setId(5);
		b.setName("b");
		c.setId(7);
		c.setName("c");
		List<TestEntry> list= Arrays.asList(a,b,c);
		//ʹ�������ڲ���ʵ��Comparator�ӿڣ�
		Collections.sort(list,new Comparator<TestEntry>(){
			@Override
			public int compare(TestEntry o1, TestEntry o2) {
				return o1.getId()-o2.getId();
			}
		});
		printList(list);
		/**
		 * ��ӡ������£�
		 * 5 : b
         * 7 : c
         * 10 : a
         * ���ϰ���id����
		 */
		//ʹ��Lambda���ʽ
		Collections.sort(list, (TestEntry obj1,TestEntry obj2)->obj1.getName().compareTo(obj2.getName()));
		printList(list);
		/**
		 * ��ӡ�������:
		 * 10 : a
         * 5 : b
         * 7 : c
         * ���ϰ���name�ַ�������
		 */
	}
	
	private static void printList(List<TestEntry> list){
		for (TestEntry entry : list){
			System.out.println(entry.getId()+" : "+entry.getName());
		}
	}
}
