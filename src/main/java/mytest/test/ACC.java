package mytest.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;



/**
 * @author zhangdb@uubee.com
 * @date 2017年5月26日 上午11:01:34
 *
 */
public class ACC {
	public static void main(String[] args) {
		try{
				
			int aa = 10;
			int ba = 0;
			int ca = 11;
			ca = aa / ba;
			System.out.println("c="+ca);
			
			
			
			try{
				File inputFile = new File("asdasd");
	            if (!inputFile.exists()) {
	                System.out.println("源文件不存在，程序终止");
	            }
	            File outputFile = new File(args[1]);
	            InputStream in = new FileInputStream(inputFile);
	            OutputStream out = new FileOutputStream(outputFile);
	 
	            byte date[] = new byte[1024];
	            int temp = 0;
	            while ((temp = in.read(date)) != -1) {
	                out.write(date);
	            }
	 
	            in.close();
	            out.close();
				
				int a = 10;
				int b = 0;
				int c = 11;
				c = a / b;
				System.out.println("c="+c);
				
			}catch(Exception e){
				System.out.println("里边的try");
			}finally{
				System.out.println("里边的finally");
			}
		}catch(Exception e){
			System.out.println("外边的try");
		}finally{
			System.out.println("外边的finally");
		}
		
	}
}

