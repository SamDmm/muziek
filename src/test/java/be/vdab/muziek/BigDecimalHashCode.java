package be.vdab.muziek;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalHashCode {
	@Test
	public void testHashCode() {
		System.out.println(BigDecimal.ONE.hashCode());
		System.out.println(BigDecimal.valueOf(1.00).stripTrailingZeros().hashCode());
		
	}
}
