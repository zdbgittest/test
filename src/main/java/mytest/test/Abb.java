package mytest.test;
/**
 * @author zhangdb@uubee.com
 * @date 2017年5月24日 下午4:04:26
 *
 */
public class Abb {
	public static void main(String[] args) {
		try{
			
			System.out.println("我是报错之前");
			
			int a =0;
			int b= 10;
			int c = b/a;
			System.out.println(c);
			System.out.println("我是报错之后");
			
		}catch(Exception e){
		}
	}
}

