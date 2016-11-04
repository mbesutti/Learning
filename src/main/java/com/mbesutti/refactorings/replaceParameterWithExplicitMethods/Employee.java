package com.mbesutti.refactorings.replaceParameterWithExplicitMethods;

abstract class Employee {
	abstract int getTypeCode();
	
	static Employee createEngineer(){
		return new Engineer();
	}
	
	static Employee createSalesman(){
		return new Salesman();
	}
	
	static Employee createManager(){
		return new Manager();
	}
}