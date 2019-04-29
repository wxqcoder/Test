package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		
		List l = new ArrayList();
		l.add("a");
		l.add("bb");
		l.add(1, "cc");
		System.out.println(l.get(2));
		
	}
}
