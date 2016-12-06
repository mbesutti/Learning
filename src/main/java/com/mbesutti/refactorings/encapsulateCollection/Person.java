package com.mbesutti.refactorings.encapsulateCollection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;

public class Person {
	public Set<Course> getCourses() {
		return _courses;
	}

//	public void setCourses(Set arg) {
//		_courses = arg;
//	}
	// gli faccio usare l'addCourse e cambio nome
	public void initializeCourses(Set<Course> arg) {
		Assert.assertTrue(_courses.isEmpty());
		Iterator<Course> iter = arg.iterator();
		while (iter.hasNext()) {
			addCourse((Course) iter.next());
		}
	}

	public void addCourse(Course arg) {
		_courses.add(arg);
	}

	public void removeCourse(Course arg) {
		_courses.remove(arg);
	}

	private Set<Course> _courses = new HashSet<Course>();
}
