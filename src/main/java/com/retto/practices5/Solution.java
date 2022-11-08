package com.retto.practices5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

public class Solution {

	final ArrayList<String> prerequisites = new ArrayList<>(); 
	
	private List<String> courses_to_take(HashMap<String, List<String>> courses) {
		
		courses.forEach(new BiConsumer<String, List<String>>() {
			@Override
			public void accept(String name, List<String> preCourses) {
				handleCourse(name, preCourses);
			}

		});
		
		
		return prerequisites;
	}
	
	private void handleCourse(String name, List<String> preCourses) {
		if(preCourses == null) {
			prerequisites.add(0, name);
		} else {
			String lastCourse = preCourses.get(preCourses.size()-1);
			int index = prerequisites.indexOf(lastCourse);
			prerequisites.add(index+1, name);	
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		HashMap<String, List<String>> courses = new HashMap<>();
		
		courses.put("CSC300", Arrays.asList("CSC100", "CSC200"));
		courses.put("CSC200", Arrays.asList("CSC100"));
		courses.put("CSC100", null);
		
		System.out.println(solution.courses_to_take(courses));
	}
}

