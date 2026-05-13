package allAnotation;

import org.testng.annotations.Test;

public class HardAssertions {
    @SuppressWarnings("unused")
	private static final boolean True = false;

    @Test
    void test() {
        //Assert.assertEquals("abc", "abc"); // True
        //Assert.assertEquals(345, 123); // False

        //Assert.assertEquals("abc", 123); // false
        //Assert.assertEquals("123", 123);

        //Assert.assertNotEquals(123, 123); // fail
        //Assert.assertNotEquals(123, 345); // pass

        //Assert.assertTrue(5 > 3); // pass
        //Assert.assertTrue(1 > 4); // fail

        // Assert.assertFalse(1 == 2); // pass
        // Assert.assertFalse(True); // fail
    }

}