package serialization;

import java.io.IOException;
import java.util.HashMap;

import tool.IOHelper;

/**
 * 实现指数的序列化存储和获取
 * 
 * @author 云奎
 *
 */
public class StrategySerialization {

	/**
	 * 存<code,indexNumber>,code是基金代码,indexNumber是指数串，以","连接，
	 * 如"399372.SZ,399373.SZ,399376.SZ,399377.SZ,399005.SZ"
	 */
	private static HashMap<String, String> map;
	private static StrategySerialization strategy;
	private static boolean inited = false;
	private static String filePath = "resources/strategy.ser";

	@SuppressWarnings("unchecked")
	private StrategySerialization() {
		IOHelper ioHelper = new IOHelper();
		try {
			map = (HashMap<String, String>) ioHelper.readFromDisk(filePath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static StrategySerialization getInstance() {
		if (!inited) {
			strategy = new StrategySerialization();
			inited = true;
		}
		return strategy;
	}

	/**
	 * 
	 * @param code
	 *            code是基金代码
	 * @param indexNumber
	 *            indexNumber是指数串，以","连接，
	 *            如"399372.SZ,399373.SZ,399376.SZ,399377.SZ,399005.SZ"
	 */
	public void recordStrategy(String code, String indexNumber) {
		IOHelper ioHelper = new IOHelper();
		map.remove(code);
		map.put(code, indexNumber);
		try {
			ioHelper.writeToDisk(filePath, map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param code
	 *            基金代码
	 * @return 基金对应的指数，
	 *         没有返回林辉的"399372.SZ,399373.SZ,399376.SZ,399377.SZ,399005.SZ"
	 */
	public String getStrategy(String code) {
		String value = map.get(code);
		if (value == null)
			return "399372.SZ,399373.SZ,399376.SZ,399377.SZ,399005.SZ";
		else
			return value;
	}
}
