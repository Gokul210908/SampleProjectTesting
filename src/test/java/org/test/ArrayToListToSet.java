package org.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayToListToSet {
	
	public static void main(String[] args) {
		int [] a = new int[5];
		
			a[0]=10;
			a[1]=20;
			a[2]=30;
			a[3]=40;
			a[4]=50;
			
			for (int i = 0; i < a.length; i++) {
				
				System.out.println(a[i]);
			}	
		
				List<Integer> li = new ArrayList<Integer>();
				for (int i = 0; i < a.length; i++) {
					li.add(a[i]);
				}
				System.out.println(li);
				
				li.add(40);
				System.out.println(li);
		
					Set<Integer> st = new LinkedHashSet<Integer>();
					st.addAll(li);
					System.out.println(st);
		
	}
	
	
	
	
	
	
	
	

}
