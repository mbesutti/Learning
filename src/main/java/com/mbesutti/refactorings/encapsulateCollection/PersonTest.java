package com.mbesutti.refactorings.encapsulateCollection;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class PersonTest {
	@Test
	public void addCourses() throws Exception {
//		Person kent = new Person();
//		Set s = new HashSet();
//		s.add(new Course("Smalltalk Programming", false));
//		s.add(new Course("Appreciating Single Malts", true));
//		kent.setCourses(s);
//		assertEquals(2, kent.getCourses().size());
//		Course refact = new Course("Refactoring", true);
//		kent.getCourses().add(refact);
//		kent.getCourses().add(new Course("Brutal Sarcasm", false));
//		assertEquals(4, kent.getCourses().size());
//		kent.getCourses().remove(refact);
//		assertEquals(3, kent.getCourses().size());
		
		Person kent = new Person();
		kent.addCourse(new Course("Smalltalk Programming", false));
		kent.addCourse(new Course("Appreciating Single Malts", true));
		assertEquals(2, kent.getCourses().size());
		Course refact = new Course("Refactoring", true);
		kent.addCourse(refact);
		kent.addCourse(new Course("Brutal Sarcasm", false));
		assertEquals(4, kent.getCourses().size());
		kent.removeCourse(refact);
		assertEquals(3, kent.getCourses().size());
	}
	
	@Test
	public void advCourses() throws Exception {
		Person person = new Person();
		Iterator iter = person.getCourses().iterator();
        int count = 0;
        while (iter.hasNext()) {
           Course each = (Course) iter.next();
           if (each.isAdvanced()) count ++;
        }
	}
}
