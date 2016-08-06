package data;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeSeriesDataTest {

	@Test
	public void test() {
		TimeSeriesData timeSeries = new TimeSeriesData();
		double[][] data = timeSeries.getTimeSeriesData("160918.SZ,161226.SZ,399372.SZ", "close", "2016-07-18", "2016-07-23");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

}
