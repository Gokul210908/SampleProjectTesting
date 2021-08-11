package org.test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SetToMap {
	
	
	
	public static void main(String[] args) {
		
		Set<Integer> st = new LinkedHashSet<Integer>();
		
		st.add(10);
		st.add(20);
		st.add(30);
		st.add(40);
		st.add(50);
		
		for (Integer x : st) {
			
			System.out.println(x);
			
		}
		
		Map<Integer, String> mp = new LinkedHashMap<Integer, String>();
		
		mp.put(10, "java");
		
		
	}
	
	

}
