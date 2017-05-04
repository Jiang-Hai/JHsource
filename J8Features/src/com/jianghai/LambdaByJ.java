package com.jianghai;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 用于测试java8 函数式编程Lambda语句
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
		//使用匿名内部类实现Comparator接口，
		Collections.sort(list,new Comparator<TestEntry>(){
			@Override
			public int compare(TestEntry o1, TestEntry o2) {
				return o1.getId()-o2.getId();
			}
		});
		printList(list);
		/**
		 * 打印结果如下：
		 * 5 : b
         * 7 : c
         * 10 : a
         * 符合按照id排序
		 */
		//使用Lambda表达式
		Collections.sort(list, (TestEntry obj1,TestEntry obj2)->obj1.getName().compareTo(obj2.getName()));
		printList(list);
		/**
		 * 打印结果如下:
		 * 10 : a
         * 5 : b
         * 7 : c
         * 符合按照name字符串排序
		 */
	}
	
	private static void printList(List<TestEntry> list){
		for (TestEntry entry : list){
			System.out.println(entry.getId()+" : "+entry.getName());
		}
	}
}
