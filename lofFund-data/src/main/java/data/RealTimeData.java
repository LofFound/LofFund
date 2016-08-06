package data;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;

import dataService.RealTimeService;
import tool.CodeTranslate;
import tool.DataTranslate;
import windapi.WSQClass;

public class RealTimeData implements RealTimeService {

	/**
	 * 
	 * @param codeNumber
	 *            股票或基金的代码串，以","连接，如"399372.SZ,399373.SZ,399376.SZ,399377.SZ,399005.SZ"
	 * @param type
	 *            希望获得的返回类型，"1"表示买一价，"2"表示交易额
	 * @return 返回type型数据串;获取失败返回空串.一个codeNumber对应二维数组的一行，每一列表示一天的数据，最近一天在最后一列
	 */
	public double[][] getRealTimeData(String codeNumber, int type) {
		WSQClass wsq = null;
		Object[] result = null;
		double[] data = null;
		try {
			CodeTranslate translate = new CodeTranslate();
			// codeNumber包含的代码个数
			int numberOfCode = translate.getNumberOfCode(codeNumber);

			// 封装的matlab
			wsq = new WSQClass();

			String arg = null;
			switch (type) {
			case 1:
				arg = "rt_ask1";
				break;
			case 2:
				arg = "rt_amt";
				break;
			default:
				return new double[0][0];
			}

			result = wsq.wsq(1, codeNumber, arg);
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
			if (wsq != null)
				wsq.dispose();
		}
	}
}
