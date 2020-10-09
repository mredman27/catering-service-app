package com.techelevator;



import java.math.BigDecimal;

import org.junit.*;

public class ChangeTest {
	
	Change change = new Change();
	
	@Test
	public void test1() {
		
		Assert.assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0},
				change.giveChange(new BigDecimal(20)));
	}
	
	@Test
	public void test2() {
		
		Assert.assertArrayEquals(new int[] {1, 0, 1, 0, 0, 0, 0},
				change.giveChange(new BigDecimal(25)));
	}
	
	@Test
	public void test3() {
		
		Assert.assertArrayEquals(new int[] {6, 1, 1, 0, 3, 1, 0},
				change.giveChange(new BigDecimal(135.85)));
	}

	@Test
	public void test4() {
		
		Assert.assertArrayEquals(new int[] {6, 1, 1, 0, 3, 0, 0},
				change.giveChange(new BigDecimal(135.75)));
	}
	
	@Test
	public void test5() {
		
		Assert.assertArrayEquals(new int[] {6, 1, 1, 0, 0, 0, 1},
				change.giveChange(new BigDecimal(135.05)));
	}
}
