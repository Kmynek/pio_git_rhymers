package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RhymersJUnitTest {
	final int STACK_CAPACITY = 12;
	final int EMPTY_STACK_VALUE = -1;
	DefaultCountingOutRhymer rhymer;

	@Before
	public void init(){
		rhymer = new DefaultCountingOutRhymer();
	}

	@Test
	public void testCountIn() {
		int expectedValue = 4;
		rhymer.countIn(expectedValue);

		int result = rhymer.peekaboo();
		Assert.assertEquals("Error. Expected value: "+expectedValue+ " result:" + result
				,expectedValue,result);
	}

	@Test
	public void testCallCheck() {

		boolean result = rhymer.callCheck();
		Assert.assertTrue("Error. Expected value:"+ true + "result:" + result
				,result);

		rhymer.countIn(888);

		result = rhymer.callCheck();
		Assert.assertFalse("Error. Expected value: "+ false + "result:" + result
				,result);
	}

	@Test
	public void testIsFull() {
		for (int i = 0; i < STACK_CAPACITY; i++) {
			boolean result = rhymer.isFull();
			Assert.assertFalse("Error. Expected value: "+ false + "result:" + result
					,result);
			rhymer.countIn(888);
		}

		boolean result = rhymer.isFull();
		Assert.assertTrue("Error. Expected value:"+ true + "result:" + result
				,result);
	}

	@Test
	public void testPeekaboo() {

		int result = rhymer.peekaboo();
		Assert.assertEquals("Error. Expected value:" + EMPTY_STACK_VALUE + "result:" + result
				, EMPTY_STACK_VALUE, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.peekaboo();
		Assert.assertEquals("Error. Expected value:" + testValue + "result:" + result
				,testValue, result);
	}
	@Test
	public void testCountOut() {


		int result = rhymer.countOut();
		Assert.assertEquals("Error. Expected value:" + EMPTY_STACK_VALUE + "result:" + result
				,EMPTY_STACK_VALUE, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.countOut();
		Assert.assertEquals("Error. Expected value:" + testValue + "result:" + result
				,testValue, result);

		result = rhymer.countOut();

		Assert.assertEquals("Error. Expected value: " + EMPTY_STACK_VALUE + "result." + result
				,EMPTY_STACK_VALUE, result);
	}


}
