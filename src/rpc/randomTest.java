package rpc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class randomTest {

	@Test
	void testSubString() {
		   String str = new String("This is a unit test.");
		   assertEquals("units", str.substring(10, 14));
	}

}
