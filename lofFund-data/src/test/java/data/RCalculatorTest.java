package data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RCalculatorTest {

	@Test
	public void test() {
		RCalculator r = new RCalculator();
		double[][] data = r.getR("160918.SZ,161226.SZ,399372.SZ");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==============");
		double[][] data1 = r.getR("160918.SZ,161226.SZ,399372.SZ", "2016-07-18", "2016-07-23");
		for (int i = 0; i < data1.length; i++) {
			for (int j = 0; j < data1[i].length; j++) {
				System.out.print(data1[i][j] + " ");
			}
			System.out.println();
		}
	}

}
