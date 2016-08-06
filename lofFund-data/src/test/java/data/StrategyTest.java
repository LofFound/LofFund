package data;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

import serialization.StrategySerialization;
import tool.IOHelper;

public class StrategyTest {

	@Test
	public void test() {
		StrategySerialization strategy = StrategySerialization.getInstance();
		System.out.println(strategy.getStrategy("a"));
		
	}

}
