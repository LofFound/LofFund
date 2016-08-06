package data;

import com.mathworks.toolbox.javabuilder.*;

import dataService.TimeSeriesService;
import tool.CodeTranslate;
import tool.DataTranslate;
import windapi.WSDClass;

public class TimeSeriesData implements TimeSeriesService {

	/**
	 * 
	 * @param codeNumber
	 *            股票或基金的代码串，以","连接，如"399372.SZ,399373.SZ,399376.SZ,399377.SZ,399005.SZ"
	 * @param type
	 *            希望获得的返回类型，如open、high、low、close等
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return 返回type型数据串，按日期升序，最近的在最后;获取失败返回空串.一个codeNumber对应二维数组的一行，每一列表示一天的数据
	 *         ，最近一天在最后一列
	 */
	public double[][] getTimeSeriesData(String codeNumber, String type, String startDate, String endDate) {
		WSDClass wsd = null;
		Object[] result = null;
		double[] data = null;
		try {
			CodeTranslate translate = new CodeTranslate();
			// codeNumber包含的代码个数
			int numberOfCode = translate.getNumberOfCode(codeNumber);

			// 封装的matlab
			wsd = new WSDClass();

			result = wsd.wsd(1, codeNumber, type, startDate, endDate);
			// 将结果转化为一维数组
			data = (double[]) ((MWArray) result[0]).getData();

			DataTranslate dataTranslate = new DataTranslate();
			// 将一维数组转化为二维
			return dataTranslate.translate(numberOfCode, data);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new double[0][0];
		} finally {
			MWArray.disposeArray(result);
			data = null;
			if (wsd != null)
				wsd.dispose();
		}
	}
}
