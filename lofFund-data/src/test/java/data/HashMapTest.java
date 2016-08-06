package data;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class HashMapTest {

	@Test
	public void test() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("a", "b");
		map.remove("a");
		map.put("a", "c");
		assertEquals("c", map.get("a"));
	}

}
