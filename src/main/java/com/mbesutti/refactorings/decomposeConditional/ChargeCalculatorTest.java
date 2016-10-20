package com.mbesutti.refactorings.decomposeConditional;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import com.mbesutti.refactorings.decomposeConditional.original.ChargeCalculator;
//import com.mbesutti.refactorings.decomposeConditional.original.Date;

public class ChargeCalculatorTest {
	ChargeCalculator _calc = new ChargeCalculator();
	
	@Before
	public void before() {
		_calc = new ChargeCalculator();
	}
	
	@Test
	public void chargeSummer() {
		assertEquals(1, _calc.charge(new Date(5), 1));
	}
	
	@Test
	public void chargeWinter() {
		assertEquals(5, _calc.charge(new Date(4), 1));
	}
}
