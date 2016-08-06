package data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RealTimeTest {

	@Test
	public void test() {
		RealTimeData r = new RealTimeData();
		double[][] data = r.getRealTimeData("160918.SZ,161226.SZ,399372.SZ", 1);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

}
