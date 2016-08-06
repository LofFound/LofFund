package tool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class IOHelper {
	
	/**
	 * 
	 * @param filepath 文件路径
	 * @param obj 写入对象
	 * @throws IOException
	 */
	public void writeToDisk(String filepath,Object obj) throws IOException{
		FileOutputStream fos=new FileOutputStream(filepath,false);
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();	
	}
	
	/**
	 * 
	 * @param filepath 文件路径
	 * @return 读出对象
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object readFromDisk(String filepath) throws IOException, ClassNotFoundException{
		FileInputStream fis=new FileInputStream(filepath);
		ObjectInputStream ois =new ObjectInputStream(fis);
		Object obj=ois.readObject();
		ois.close();
		return obj;

	}
	
}

