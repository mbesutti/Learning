package com.mbesutti.profile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProfileTest {

	@Test
	public void sumTo() {
		assertThat(new Profile().sumFromZeroTo(100), is(5050));
	}
	
	@Test
	public void accumulate() {
		SumAccumulator accumulator = new SumAccumulator().add(5).add(2);
		assertThat(accumulator.total(), is(7));
	}
}
