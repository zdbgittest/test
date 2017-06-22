package mytest.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * Hello world!
 *
 */
public class App {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final static String correlationID = UUID.randomUUID().toString();
	protected static final ExecutorService executorService; //线程池
	
	static{
    	executorService = Executors.newFixedThreadPool(10);
    	System.out.println("定时任务公共线程池["+executorService+"]初始化创建成功");
    }
	
	
    public static void main( String[] args ){
//    	System.out.println(marginOfTwoTime("2016-04-04 12:12:12","2015-04-06 12:12:12"));
//    	
//    	BigDecimal b1 = new BigDecimal(21313213);
//    	BigDecimal b = b1.divide(new BigDecimal(122), 3, RoundingMode.HALF_UP);
//    	System.out.println(b);
    	try {
	    	final CountDownLatch latch = new CountDownLatch(100);
	    	for(int i=0;i<100;i++){
	    		executorService.execute(new Runnable() {
	    			public void run() {
	    				try {
	    					Thread.sleep(500);
	    					System.out.println("测试一下报错了，是否继续执行下去");
//	    					int a = 20;
//	    					int b = 0;
//	    					int c = a/b;
//	    					System.out.println("运行结束，上边报错了，不知道报错成什么样"+c);
	    				} catch (InterruptedException e) {
	    					e.printStackTrace();
	    				}finally{
	    					latch.countDown();
	    				}
	    			}
	    		});
	    	}
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	System.out.println("100线程执行结束");
    }
    
    public static void testExecutor(){
    }
    
    
    //得到上月的第一天
    public static void getMinDayOfLastMonth(){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(new Date());
    	calendar.add(Calendar.MONTH, -1);
    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
    	System.out.println(dateFormat.format(calendar.getTime()));
    	
    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    	System.out.println(dateFormat.format(calendar.getTime()));
    }
    //得到上月最后一天
    public static void getMaxDayOfLastMonth(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
    	calendar.setTime(new Date());
    	calendar.add(Calendar.MONTH, -1);
    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    	System.out.println(dateFormat.format(calendar.getTime())+" 00:00:00");
    }
    
    /**
     * Function: 得到月初	
     * @author zhangdb@uubee.com
     * @date 2017年5月19日 下午4:41:12
     * @param date
     * @return
     * @throws ParseException
     * @return String
     * @throws
     */
    public static String getMinMonthDate(String date) throws ParseException{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat.parse(date));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dateFormat.format(calendar.getTime());
	}
    
    /**
	* 获取月份最后日期
	* @param date
	* @return
	* @throws ParseException
	*/
	public static String getMaxMonthDate(String date) throws ParseException{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat.parse(date));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dateFormat.format(calendar.getTime());
	}
	
	public static Integer marginOfTwoTime(String beginTime,String endTime){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer days = 0;
		try {
			Date date1 = dateFormat.parse(beginTime);
			Date date2 = dateFormat.parse(endTime);
			
			Calendar cal1 = Calendar.getInstance();    
	        cal1.setTime(date1); 
	        Calendar cal2 = Calendar.getInstance();    
	        cal2.setTime(date2);
	        
	        while(cal2.after(cal1)){
	            days++;
	            cal1.add(Calendar.DAY_OF_YEAR, 1);
	        }
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}
}
