package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
/////////////// VAR'S FOR TEST CASES ///////////////
	
	//Method 1 - calculateColumnTotal
	private Values2D value1_1;
	private Values2D value1_2;
	private Values2D value1_3;
	private Values2D value1_4; 

	//Method 2 - calculateRowTotal
	private Values2D value2_1;
	private Values2D value2_2;
	private Values2D value2_3;

	//Method 3 - createNumberArray
	private double[] value3_1;
	private Number[] expected3_1;
	private double[] value3_2 ;
	private Number[] expected3_2;
	private double[] value3_3;
	private Number[] expected3_3;
	
	//Method 4 - createNumberArray2D
	private double[][] value4_1 ;
	private Number[][] expected4_1;
	private double[][] value4_2 ;
	private double[][] expected4_2 ;
	private double[][] value4_3 ;
	private Number[][] expected4_3;

	//Method 5 - getCumulativePercentages
	private KeyedValues value5_1 ;
	private DefaultKeyedValues expected5_1 ;
	private KeyedValues value5_2 ;
	private DefaultKeyedValues expected5_2 ;
	private KeyedValues value5_3 ;
	private DefaultKeyedValues expected5_3 ;
	private KeyedValues value5_4 ;
	private DefaultKeyedValues expected5_4 ;
		
/////////////// @Before - Creating the mock objects  ///////////////
		
	@Before
	public void setUp() throws Exception {
		
		//Method 1 - Test case 1_1
		Mockery mockingContext1_1 = new Mockery();
		value1_1 = mockingContext1_1.mock(Values2D.class);
		mockingContext1_1.checking(new Expectations() {
			{
				one(value1_1).getRowCount(); 
				will(returnValue(2));
				one(value1_1).getValue(0, 0); 
				will(returnValue((Number)7.5)); 
				one(value1_1).getValue(1, 0);
				will(returnValue((Number)2.5));
			}
		});
		
		//Method 1 - Test case 1_2
		Mockery mockingContext1_2 = new Mockery();
		value1_2 = mockingContext1_2.mock(Values2D.class);
		mockingContext1_2.checking(new Expectations() {
			{
				one(value1_2).getRowCount(); 
				will(returnValue(2));
				one(value1_2).getValue(0, 0); 
				will(returnValue(-2.5)); 
				one(value1_2).getValue(1, 0);
				will(returnValue((Number)7.5));
			}
		});
		
		//Method 1 - Test case 1_3
		Mockery mockingContext1_3 = new Mockery();
		value1_3 = mockingContext1_3.mock(Values2D.class);
		mockingContext1_3.checking(new Expectations() {
			{
				one(value1_3).getRowCount(); 
				will(returnValue(1));
				one(value1_3).getValue(0, 0); 
				will(returnValue((Number)2.5)); 
			}
		});
		
		//Method 1 - Test case 1_4 remains null 
		
		
//		#####################################################
		//Method 2 - Test case 2_1
		Mockery mockingContext2_1 = new Mockery();
		value2_1 = mockingContext2_1.mock(Values2D.class);
		mockingContext2_1.checking(new Expectations() {
			{
				one(value2_1).getColumnCount(); 
				will(returnValue(2));
				one(value2_1).getValue(0, 0); 
				will(returnValue((Number)7.5)); 
				one(value2_1).getValue(0, 1);
				will(returnValue((Number)2.5));
			}
		});
		
		//Method 2 - Test case 2_2
		Mockery mockingContext2_2 = new Mockery();
		value2_2 = mockingContext2_2.mock(Values2D.class);
		mockingContext2_2.checking(new Expectations() {
			{
				one(value2_2).getColumnCount(); 
				will(returnValue(2));
				one(value2_2).getValue(1, 0); 
				will(returnValue(-2.5)); 
				one(value2_2).getValue(1, 1);
				will(returnValue((Number)7.5));
			}
		});		
		
		//Method 2 - Test case 2_3
		Mockery mockingContext2_3 = new Mockery();
		value2_3 = mockingContext2_3.mock(Values2D.class);
		mockingContext2_3.checking(new Expectations() {
			{
				one(value2_3).getColumnCount(); 
				will(returnValue(1));
				one(value2_3).getValue(0, 0); 
				will(returnValue(2.5)); 
			}
		});	
		
//##################################################
		//Method 3 - Test case 3_1
		 value3_1 = new double[] {1.0,0, 3.0};
		expected3_1 = new Number[value3_1.length];
		for (int i = 0; i < value3_1.length; i++) {
			expected3_1[i] = (Number) value3_1[i];
		}
		
		//Method 3 - Test case 3_2
		value3_2 = new double[] {-1.0,2.0, 3.0};
		expected3_2 = new Number[value3_2.length];
		for (int i = 0; i < value3_2.length; i++) {
			expected3_2[i] = (Number) value3_2[i];
		}
		
		//Method 3 - Test case 3_3
		value3_3 = new double[] {-1.0,-2.0, -3.0};

		//Method 4 - Test case 4_1
		 value4_1 = new double[][]{ {1.0,2.0,3.0} ,{0.0,0.0,0.0} };
		 expected4_1= new Number[][]{ {1.0,2.0,3.0} ,{0.0,0.0,0.0} };

		//Method 4 - Test case 4_2
		 value4_2 = new double[][]{ {-1.0,-2.0,-3.0},{-1.0,-2.0,-3.0} };
		 expected4_2 = new double[][]{ {-1.0,-2.0,-3.0},{-1.0,-2.0,-3.0} };

		//Method 4 - Test case 4_3
		 value4_3 = new double[][]{ {1.0,2.0,3.0} ,{-1.0,-2.0,-3.0} };
		 expected4_3= new Number[][]{ {1.0,2.0,3.0} ,{-1.0,-2.0,-3.0} };
		 
//###########################################
		//Method 5 - Test case 5_1
		Mockery mockingContext5_1 = new Mockery();
		value5_1 = mockingContext5_1.mock(KeyedValues.class);
		mockingContext5_1.checking(new Expectations() {
			{
				allowing(value5_1).getItemCount(); 
				will(returnValue(3));
				allowing(value5_1).getKey(0);
				will(returnValue(0));
				allowing(value5_1).getValue(0);
				will(returnValue((Number)5)); 

				allowing(value5_1).getKey(1);
				will(returnValue(1));
				allowing(value5_1).getValue(1);
				will(returnValue((Number)9));

				allowing(value5_1).getKey(2);
				will(returnValue(2));
				allowing(value5_1).getValue(2);
				will(returnValue((Number)2));
			}
		});	
		
		expected5_1 = new DefaultKeyedValues();

		expected5_1.setValue(0, (Number)0.3125);
		expected5_1.setValue(1, (Number)0.875);
		expected5_1.setValue(2, (Number)1.0);

		//Method 5 - Test case 5_2
		Mockery mockingContext5_2 = new Mockery();
		value5_2 = mockingContext5_2.mock(KeyedValues.class);
		mockingContext5_2.checking(new Expectations() {
			{
				allowing(value5_2).getItemCount(); 
				will(returnValue(1));
				allowing(value5_2).getKey(0);
				will(returnValue(0));
				allowing(value5_2).getValue(0);
				will(returnValue((Number)1.0)); 
			}
		});	
		
		expected5_2 = new DefaultKeyedValues();
		expected5_2.setValue(0, (Number)1.0);
	
		//Method 5 - Test case 5_3
		Mockery mockingContext5_3 = new Mockery();
		value5_3 = mockingContext5_3.mock(KeyedValues.class);
		mockingContext5_3.checking(new Expectations() {
			{
				allowing(value5_3).getItemCount(); 
				will(returnValue(2));
				allowing(value5_3).getKey(0);
				will(returnValue(0));
				allowing(value5_3).getValue(0);
				will(returnValue((Number)(-5)));
				allowing(value5_3).getKey(1);
				will(returnValue(1));
				allowing(value5_3).getValue(1);
				will(returnValue((Number)5));
			}
		});	
		
		expected5_3 = new DefaultKeyedValues();
		expected5_3.setValue(0, (Number)0.5);
		expected5_3.setValue(1, (Number)0.5);


		//Method 5 - Test case 5_4
		Mockery mockingContext5_4 = new Mockery();
		value5_4 = mockingContext5_4.mock(KeyedValues.class);
		mockingContext5_4.checking(new Expectations() {
			{
				allowing(value5_4).getItemCount(); 
				will(returnValue(2));
				
				allowing(value5_4).getKey(0);
				will(returnValue(0));
				allowing(value5_4).getValue(0);
				will(returnValue("5")); 

				allowing(value5_4).getKey(1);
				will(returnValue(1));
				allowing(value5_4).getValue(1);
				will(returnValue("5"));
			}
		});	
	}

/////////////// TEST FUNCTION - calculateColumnTotal ///////////////
	
	//Test case 1_1
	@Test
	public void calculateColumnTotalForTwoPositiveValues() { //calculate column total 
		double result1_1 = DataUtilities.calculateColumnTotal(value1_1, 0);
		assertEquals("Two postive values must return 10", 10.0, result1_1, .000000001d);
	}
	
	//Test case 1_2
	@Test
	public void calculateColumnTotalForOnePositiveOneNegativeValues() { //calculate column total 
		double result1_2 = DataUtilities.calculateColumnTotal(value1_2, 0);
		assertEquals("One positive and one negative value must return 5", 5, result1_2, .000000001d);
	}
	
	//Test case 1_3
	@Test
	public void calculateColumnTotalForOneValue() { //calculate column total 
		double result1_3 = DataUtilities.calculateColumnTotal(value1_3, 0);
		assertEquals("One null value - expect a NullPointerException error", 2.5, result1_3, .000000001d);
	}
	
	//Test case 1_4
	@Test (expected=NullPointerException.class)
	public void calculateColumnTotalForNullValues() { //calculate column total 
		double result1_4 = DataUtilities.calculateColumnTotal(value1_4, 0);
		assertEquals("Two null values - expect a NullPointerException error", 2.5, result1_4, .000000001d);
	}

/////////////// TEST FUNCTION - calculateRowTotal ///////////////
	
	//Test case 2_1
	@Test
	public void calculateRowTotalForTwoPositiveValues() { 
		double result2_1 = DataUtilities.calculateRowTotal(value2_1, 0);
		assertEquals("Two postive values must return 10", 10.0, result2_1, .000000001d);
	}
	
	//Test case 2_2
	@Test
	public void calculateRowTotalForOnePositiveOneNegativeValues() { 
		double result2_2 = DataUtilities.calculateRowTotal(value2_2, 1);
		assertEquals("One positive and one negative value must return 5", 5.0, result2_2, .000000001d);
	}
	
	//Test case 2_3 
	@Test
	public void calculateRowTotalForOneValue() { 
		double result2_3 = DataUtilities.calculateRowTotal(value2_3, 0);
		assertEquals("One value - we expect 2.5", 2.5, result2_3, .000000001d);
	}
	
	//Test case 2_4 
	@Test(expected=NullPointerException.class)
	public void calculateRowTotalForNullValues() { 
		double result2_4 = DataUtilities.calculateRowTotal(null, 0);
		assertEquals("Two null values - expect a NullPointerException error",5.0,result2_4, .000000001d);
	}
	
/////////////// TEST FUNCTION - createNumberArray ///////////////
	
	//Test case 3_1 
	@Test
	public void createNumberArrayForArrayOfPositveDoubles() { 
		Number [] result3_1 = DataUtilities.createNumberArray(value3_1);
		assertArrayEquals("Same array should be created ",expected3_1,result3_1);
	}	
	
	//Test case 3_2 
	@Test
	public void createNumberArrayForArrayOfPositveDoublesandOneNegative() { 
		Number [] result3_2 = DataUtilities.createNumberArray(value3_2);
		assertArrayEquals("Same array should be created ", expected3_2,result3_2);
	}
	
	//Test case 3_3
	@Test
	public void createNumberArrayForArrayOfNegativeDoubles() { 
		Number [] result3_3 = DataUtilities.createNumberArray(value3_3);
		assertArrayEquals("Same array should be created ", expected3_3, result3_3);
	}
	
	//Test case 3_4 
	@Test(expected=IllegalArgumentException.class)
	public void createNumberArrayForNullInput() {
		Number [] result3_4 = DataUtilities.createNumberArray(null);

	}

/////////////// TEST FUNCTION - createNumberArray2D ///////////////
	
	//Test case 4_1 
	@Test
	public void createNumberArray2DForArrayOfPositveDoubles() { 
		Number [][] result4_1 = DataUtilities.createNumberArray2D(value4_1);
		assertArrayEquals("Same array should be created ", expected4_1, result4_1);
	}	
	
	//Test case 4_2 
	@Test
	public void createNumberArray2DForArrayOfPositveDoublesandOneNegative() { 
		Number [][] result4_2 = DataUtilities.createNumberArray2D(value4_2);
		assertArrayEquals("Same array should be created ", expected4_2, result4_2);
	}	
	
	//Test case 4_3
	@Test
	public void createNumberArray2DForArrayOfNegativeDoubles() { 
		Number [][] result4_3 = DataUtilities.createNumberArray2D(value4_3);
		assertArrayEquals("Same array should be created ", expected4_2, result4_3);
	}	

	//Test case 4_4 
	@Test(expected=IllegalArgumentException.class)
	public void createNumberArray2DForNullInput() {
		Number [][] result4_4 = DataUtilities.createNumberArray2D(null);
	}
		
/////////////// TEST FUNCTION - getCumulativePercentages ///////////////
	
	//Test case 5_1 
	@Test
	public void getCumulativePercentagesForThreeValues() { 
		KeyedValues result5_1 = DataUtilities.getCumulativePercentages(value5_1);
		assertEquals("Same array should be created ", expected5_1, result5_1);
	}	

	//Test case 5_2 
	@Test
	public void getCumulativePercentagesForOneValueShouldReturnHundred() { 
		KeyedValues result5_2 = (DefaultKeyedValues)DataUtilities.getCumulativePercentages(value5_2);
		assertEquals("Expected to return 100%", expected5_2, result5_2);
	}
	
	//Test case 5_3 
	@Test
	public void getCumulativePercentagesForOnePositiveAndOneNegativeValues() { 
		KeyedValues result5_3 = DataUtilities.getCumulativePercentages(value5_3);
		assertEquals("One positive value and one negative ", expected5_3, result5_3);
	}
	
	//Test case 5_4 
	@Test(expected=IllegalArgumentException.class)
	public void getCumulativePercentagesForNullInput() { 
		KeyedValues result5_4 = DataUtilities.getCumulativePercentages(null);
	}
	
	//Test case 5_5 
	@Test(expected=IllegalStateException.class)
	public void getCumulativePercentagesForInvalidInput() { 
		KeyedValues result5_5 = DataUtilities.getCumulativePercentages(value5_4);
	}
	
/////////////// @After - Test's are over  ///////////////
	
	@After
	public void tearDown() throws Exception {
	}
}