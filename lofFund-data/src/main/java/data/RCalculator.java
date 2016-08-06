package data;

import com.mathworks.toolbox.javabuilder.*;

import dataService.RCalculatorService;
import tool.CodeTranslate;
import tool.DataTranslate;
import windapi.R_Anydays;
import windapi.R_Latest;

public class RCalculator implements RCalculatorService {

	/**
	 * 
	 * @param codeNumber
	 *            股票或基金的代码串，以","连接，如"399372.SZ,399373.SZ,399376.SZ,399377.SZ,399005.SZ"
	 * @return 返回最近一天的R，如果当天还没有收盘返回-infinite;获取失败返回空串.一个codeNumber对应二维数组的一行，
	 *         每一列表示一天的数据，最近一天在最后一列
	 */
	public double[][] getR(String codeNumber) {
		R_Latest r = null;
		Object[] result = null;
		double[] data = null;
		try {
			CodeTranslate translate = new CodeTranslate();
			// codeNumber包含的代码个数
			int numberOfCode = translate.getNumberOfCode(codeNumber);

			// 封装的matlab
			r = new R_Latest();

			result = r.profit_recent(1, codeNumber);
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
			if (r != null)
				r.dispose();
		}
	}

	/**
	 * 
	 * @param codeNumber
	 *            股票或基金的代码串，以","连接，如"399372.SZ,399373.SZ,399376.SZ,399377.SZ,399005.SZ"
	 * @param startDate
	 * @param endDate
	 * @return 返回startDate+1到endDate的R;获取失败返回空串.一个codeNumber对应二维数组的一行，每一列表示一天的数据
	 *         ，最近一天在最后一列
	 */
	public double[][] getR(String codeNumber, String startDate, String endDate) {
		R_Anydays r = null;
		Object[] result = null;
		double[] data = null;
		try {
			CodeTranslate translate = new CodeTranslate();
			// codeNumber包含的代码个数
			int numberOfCode = translate.getNumberOfCode(codeNumber);

			// 封装的matlab
			r = new R_Anydays();

			result = r.profit_any_days(1, codeNumber, startDate, endDate);
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
			if (r != null)
				r.dispose();
		}
	}
}
