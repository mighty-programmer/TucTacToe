package test;

import model.ChartList;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ChartListTest {
	ChartList<String> chartList;
	
	@BeforeEach
	void init() {
		chartList = new ChartList<>(1);
	}
	
	@Test
	@DisplayName("Testing growing array method")
	void testGrowingMethod(){
		chartList.addExtend("d");
		chartList.addExtend("a");
		chartList.addExtend("x");
		chartList.addExtend("e");
		
		assertAll("Testing",
				()->assertEquals(chartList.get(0),"a","The first name should be a"),
				()->assertEquals(chartList.get(1),"d","The second name should be d"),
				()->assertEquals(chartList.get(2),"e","The third name should be e"),
				()->assertEquals(chartList.get(3),"x","The fourth name should be x"),
				()->assertThrows(IndexOutOfBoundsException.class, ()->chartList.get(4))	
				);
	}
	
	@Test
	@DisplayName("New ChartList must have correct capacity")
	void testInitialCapacity() {
		assertEquals(chartList.capacity(), 5,"Initial Capacity should be 5");
	}
	
	
	@Test
	@DisplayName("Chart list access should respects List boundaries")
	void testGetOutOfBoundsThrowsException() {
		assertThrows(IndexOutOfBoundsException.class, ()->chartList.get(-1));		
		Throwable ule = assertThrows(IndexOutOfBoundsException.class, ()->chartList.get(6));
		assertEquals(ule.getMessage(), "6 is not a valid index");
	}
	
	
	@Test
	@DisplayName("ChartList size must increment after each add")
	void testSizeIncrement() {
		chartList.add("Nektarios");
		chartList.add("Yannis");
		assertEquals(chartList.size(), 2,"Initial Capacity should be 2");
	}
	
	
	@Test
	@DisplayName("Full List should not accept more elements")
	void testAddRespectsLimits() {
		chartList.add("Nektarios");
		chartList.add("Yannis");
		chartList.add("Vasilis");
		chartList.add("Nikos");
		chartList.add("George");		
		assertEquals(chartList.size(), 5,"List size should be 5");
	}
	
	
	
	@Test
	@DisplayName("Chart List items should be ordered")
	void testAddPreservesOrdering() {
		chartList.add("Nektarios");
		chartList.add("Yannis");
		chartList.add("Vasilis");
		chartList.add("Nikos");
		chartList.add("George");		
		assertAll("Order Preserving",
				()->assertEquals(chartList.get(0), "George"),
				()->assertEquals(chartList.get(1), "Nektarios"),
				()->assertEquals(chartList.get(2), "Nikos"),
				()->assertEquals(chartList.get(3), "Vasilis"),
				()->assertEquals(chartList.get(4), "Yannis")
				);
	}
	
	
	@Test
	@DisplayName("Adding empty List should not increment the list size")
	void testAddEmptyChartList() {
		chartList.add("Nektarios");
		chartList.add("Yannis");
		
		String[] second = new String[2];
		chartList.addAll(second);
		assertEquals(chartList.size(),2,"List size should be 2");		
	}
	
	
	@Test
	@DisplayName("Adding a non empty ChartList should increment the list size, and contain the elements")
	void testAddNonEmptyChartList() {
		chartList.add("Nektarios");
		chartList.add("Yannis");
		
		String[] second = {"Vasilis","Petros"};		
		chartList.addAll(second);
		/*
		 * assertEquals(chartList.size(),4,"List size should be 2");
		 * assertEquals(chartList.get(2), "Vasilis"); assertEquals(chartList.get(3),
		 * "Petros");
		 */
		
		assertEquals(chartList.size(),4,"List size should be 2");
				
	}	
	
	
	@Test
	@DisplayName("Empty List should have size 0")
	void testEmptyListConsistency() {
		assumeTrue(chartList.isEmpty()); // the next test will be executed only when chartList is empty...
		String[] array = chartList.toArray(new String[0]);		
		assertEquals(array.length, 0);
		assertEquals(chartList.size(), 0, "Non empty list should have size > 0");
	}
	
	
}
