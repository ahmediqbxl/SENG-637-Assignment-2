package org.jfree.data.test;
import static org.junit.Assert.*; 

import java.security.InvalidParameterException;

import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
	
//	test case 1- SUT = contains()
	private Range range_1; // create one generic range to be tested
	
//	test case 2- SUT = combine()
	private Range range_2;
	private Range range_2_5_1;
	private Range range_2_5_2;
	private Range range_2_6_1;
	private Range range_2_6_2;
	private Range range_2_7_1;
	private Range range_2_7_2;
	private Range range_2_8_1;
	private Range range_2_8_2;
	
//	test case 3 - SUT = expand()
	private Range range_3;
	
	private Range expectedRange_3_5;
	private Range expectedRange_3_6;
	private Range expectedRange_3_7;
	private Range expectedRange_3_8;
	private Range expectedRange_3_9;
	private Range expectedRange_3_12;
	private Range expectedRange_3_13;
	private Range expectedRange_3_14;
	private Range expectedRange_3_15;
	private Range expectedRange_3_17;
	
	private double lowerMargin_3 = 0.5;
	private double upperMargin_3 = 0.5;
	
	private double lowerMargin_3_1 = 0.5;
	private double upperMargin_3_1 = 0.5;
	
	private double lowerMargin_3_2 = Double.NaN;
	
	private double upperMargin_3_3 = Double.NaN;
	
	private double lowerMargin_3_4 = -0.1;
	
	
	private double lowerMargin_3_5 = 0.0;
	private double lowerMargin_3_6 = 0.1;
	private double lowerMargin_3_7 = 0.5;
	private double lowerMargin_3_8 = 0.9;
	
	private double lowerMargin_3_9 = 1.0;
	private double upperMargin9 = 1.0;
	private double lowerMargin_3_10 = 1.1;
	
	private double lowerMargin_3_11 = 0.1;
	private double upperMargin_3_11 = -0.1;
	
	private double upperMargin_3_12 = 0.0;
	private double upperMargin_3_13 = 0.1;
	private double upperMargin_3_14 = 0.9;
	private double upperMargin_3_15 = 1.0;
	
	private double upperMargin_3_16 = 1.1;
	
	private double lowerMargin_3_17 = 0.0;
	private double upperMargin_3_17 = 0.0;
	
//	test case 4 - SUT = getLnegth()
	private Range range_4_1;
	private Range range_4_2;
	private Range range_4_3;
	private Range range_4_4;
	private Range range_4_5;
	
	
	
//test case 5 - SUT =	constrain()
	private Range range_5;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass()throws Exception {
		

		
		
		
	}
	@Before
	public void setUp() throws Exception {
		
		
//		test case 1- SUT = contains()
		range_1 = new Range(-10,10);
		
		
//		test case 2- SUT = combine()
		range_2 = new Range(-5,5);
		
		range_2_5_1 = new Range(0,5);
		range_2_5_2 = new Range(-5,0);
		range_2_6_1 = new Range(-2,2);
		range_2_6_2 = new Range(-5,5);
		range_2_7_1 = new Range(2,5);
		range_2_7_2 = new Range(-5,-2);
		range_2_8_1 = new Range(-2,5);
		range_2_8_2 = new Range(-5,2);
		
		
		
		
		
//		test case 3 - SUT = expand()
		
		range_3 = new Range(-5,5);
		
		expectedRange_3_5= new Range(-5,10);
		expectedRange_3_6 = new Range(-6,10);
		expectedRange_3_7 = new Range(-10,10);
		expectedRange_3_8 = new Range(-14,10);
		expectedRange_3_9 = new Range(-15,15);
		expectedRange_3_12 = new Range(-10,5);
		expectedRange_3_13 = new Range(-10,6);
		expectedRange_3_14 = new Range(-10,14);
		expectedRange_3_15 = new Range(-10,15);
		expectedRange_3_17 = new Range(-5,5);
		
		
		
		
//		test case 4 - SUT = getLength()
		range_4_1 = new Range(0,8);
		range_4_2 = new Range(1.5,11.5);
		range_4_3 = new Range(-5,10);
		range_4_4 = new Range(0,0);
		range_4_5 = new Range(Double.NaN, Double.NaN);
		
		
		
		
	//test case 5 - SUT = constrain()
		range_5 = new Range(-5,5);
	}

	
// #######################################################
//	TEST 1 ------>>>>>    SUT = Contains(double value)
	@Test
	public void containsTestBLB() {
		assertFalse("Test for BLB", range_1.contains(-11));
	}
	@Test
	public void containsTestLB() {
		assertTrue("Test for LB", range_1.contains(-10));
	}
	@Test
	public void containsTestALB() {
		assertTrue("Test for ALB", range_1.contains(-9.9));
	}
	@Test
	public void containsTestNOM() { 
		assertTrue("Test for NOM", range_1.contains(0));
	}
	@Test
	public void containsTestBUB() { 
		assertTrue("Test for BUB", range_1.contains(9.9));
	}
	@Test
	public void containsTestUB() { 
		assertTrue("Test for UB", range_1.contains(10));
	}
	@Test
	public void containsTestAUB() { 
		assertFalse("Test for AUB", range_1.contains(11));
	}
	
	
//	###########################################
//	test case 2 ---->>>> SUT = combineRange range1, Range range2()
	
	@Test
	public void combineRangeTwoNUll() {
		assertEquals("Range one returns (-5,5)", range_2, Range.combine(range_2, null));
	}
	@Test
	public void combineRangeOneNull() {
		assertEquals("Range two returns (-5,5)", range_2, Range.combine(null,range_2));
	}
	@Test
	public void combineBothNullRange() {
		assertNull("Range retruns null", Range.combine(null, null));
	}
	@Test
	public void combineSameRange() {
		assertEquals("If both ranges are the same", range_2, Range.combine(range_2, range_2));
	}
	@Test
	public void combineRangeWithOneSimilarPoint() {
		assertEquals("Pass two ranges which both share a boundary point", range_2, Range.combine(range_2_5_1, range_2_5_2));
	}
	@Test
	public void combineRangeWithNestedRangeInside() {
		assertEquals("Pass two ranges with one nested inside the other", range_2, Range.combine(range_2_6_1,range_2_6_2));
	}
	@Test
	public void combineRangeWithNoMutualPoints() {
		assertEquals("Pass two ranges that have no mutual values", range_2, Range.combine(range_2_7_1,range_2_7_2));
	}
	@Test
	public void combineRangeOverlap() {
		assertEquals("pass two ranges that overlap",range_2, Range.combine(range_2_8_1, range_2_8_2));
	}
	
	
//	############################################
//	Test Case 3 ---->>>>> SUT = expand(Range range,double lower, double upper)
	
//	1
	@Test(expected = IllegalArgumentException.class)
	public void expandTestForNullRange() {
		Range.expand(null, lowerMargin_3_1, upperMargin_3_1);
	}
//	2
	@Test(expected = InvalidParameterException.class)
	public void expandTestForNullLowerMargin() {
		Range.expand(range_3, lowerMargin_3_2, upperMargin_3);
	}
//	3
	@Test(expected = InvalidParameterException.class)
	public void expandTestForNullUpperMargin() {
		Range.expand(range_3, lowerMargin_3, upperMargin_3_3);
	}
//	4
	@Test(expected = InvalidParameterException.class)
	public void expandTestForLowermargin_BLB() {
		Range.expand(range_3, lowerMargin_3_4, upperMargin_3);
	}
//	5
	@Test
	public void expandTestForLowerMargin_LB() {
		assertEquals("Expected range is (-5,10)", expectedRange_3_5, Range.expand(range_3, lowerMargin_3_5, upperMargin_3));
	}
//	6
	@Test
	public void expandTestForLowerMargin_ALB() {
		assertEquals("Expected range is (-6,10)", expectedRange_3_6, Range.expand(range_3, lowerMargin_3_6, upperMargin_3));
	}
//	7
	@Test
	public void expandTestForLowerMargin_NOM() {
		assertEquals("Expected range is (-10,10)", expectedRange_3_7, Range.expand(range_3, lowerMargin_3_7, upperMargin_3));
	}
//	8
	@Test
	public void expandTestForLowerMargin_BUB() {
		assertEquals("Expected range is (-14,10)", expectedRange_3_8, Range.expand(range_3, lowerMargin_3_8, upperMargin_3));
	}
//	9
	@Test
	public void expandTestForLowerMargin_UB() {
		assertEquals("Expected range is (-15,15)", expectedRange_3_9, Range.expand(range_3, lowerMargin_3_9, upperMargin_3));
	}
//	10
	@Test(expected = InvalidParameterException.class)
	public void expandTestForLowerMargin_AUB() {
		Range.expand(range_3, lowerMargin_3_10, upperMargin_3);
	}
//	11
	@Test(expected = InvalidParameterException.class)
	public void expandTestForUpperMargin_BLB() {
		Range.expand(range_3, lowerMargin_3, upperMargin_3_11);
	}
//	12
	@Test
	public void expandTestForUpperMargin_LB() {
		assertEquals("Expected range is (-10,5)", expectedRange_3_12, Range.expand(range_3, lowerMargin_3, upperMargin_3_12));
	}
//	13
	@Test
	public void expandTestForUpperMargin_ALB() {
		assertEquals("Expected range is (-10,6)", expectedRange_3_13, Range.expand(range_3, lowerMargin_3, upperMargin_3_13));
	}
//	14
	@Test
	public void expandTestForUpperMargin_NOM() {
		assertEquals("Expected range is (-10,14)", expectedRange_3_14, Range.expand(range_3, lowerMargin_3, upperMargin_3_14));
	}
//	15 
	@Test
	public void expandTestForUpperMargin_BUB() {
		assertEquals("Expected range is (-10,15)", expectedRange_3_15, Range.expand(range_3, lowerMargin_3, upperMargin_3_15));	
	}
//	16
	@Test(expected = InvalidParameterException.class)
	public void expandTestForUpperMargin_UB() {
		Range.expand(range_3, lowerMargin_3_4, upperMargin_3);
	}
//	17
	@Test
	public void expandTestUpperMargin_AUB() {
		assertEquals("Expected range is (-5,5)", expectedRange_3_17, Range.expand(range_3, lowerMargin_3_17, upperMargin_3_17));
	}
	
	
//	#########################################
//	test case 4 ----->>>>>getLength()
	
	@Test
	public void getLengthOfPositiveRange() {
		assertEquals("The length of the range 0,8 should be 8", 8, range_4_1.getLength(), .000000001d);
	}
	@Test
	public void getLengthWhenDecimalsInvolved() {
		assertEquals("the length of the range 1.5,11 should be 10", 10, range_4_2.getLength(), .000000001d);
	}
	@Test
	public void getLengthWithNegativeNumbers() {
		assertEquals("The length of the range -5,10 should be 15", 15, range_4_3.getLength(), .000000001d);
	}
	@Test
	public void getLengthOfZero() {
		assertEquals("The length of the range 0,0 should be 0", 0, range_4_4.getLength(), .000000001d);
	}
	@Test(expected = NullPointerException.class)
	public void getLengthWithNUllValues() {
		range_4_5.getLength();
	}
	
//#################################################
//	test case 5 ----->>>>>> SUT = constrain()
	
	@Test
	public void constrain_BLB() {
		assertEquals("For the range (-5,5), the expected return of the parameter -5.1 is -5", -5,range_5.constrain(-5.1),.000000001d );
	}
	@Test
	public void constrain_LB() {
		assertEquals("For the range (-5,5), the expected return of the parameter -5 is -5", -5,range_5.constrain(-5),.000000001d );
	}
	@Test
	public void constrain_ALB() {
		assertEquals("For the range (-5,5), the expected return of the parameter -4.9 is -4.9", -5,range_5.constrain(-4.9),.000000001d );
	}
	@Test
	public void constrain_NOM() {
		assertEquals("For the range (-5,5), the expected return of the parameter 0 is 0", 0 ,range_5.constrain(0),.000000001d );
	}
	@Test
	public void constrain_BUB() {
		assertEquals("For the range (-5,5), the expected return of the parameter 4.9 is 4.9", 4.9,range_5.constrain(4.9),.000000001d );
	}
	@Test
	public void constrain_UB() {
		assertEquals("For the range (-5,5), the expected return of the parameter 5 is 5", 55,range_5.constrain(5),.000000001d );
	}
	@Test
	public void constrain_AUB() {
		assertEquals("For the range (-5,5), the expected return of the parameter 5.1 is 5", 5,range_5.constrain(5.1),.000000001d );
	}
	
//	#######################################################################	
	
	@After
	public void tearDown() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
