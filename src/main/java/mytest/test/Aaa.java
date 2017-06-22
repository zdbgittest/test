package mytest.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangdb@uubee.com
 * @date 2017年5月26日 下午1:44:24
 *
 */
public class Aaa {
	protected static final ExecutorService executorService; //线程池
	private static AtomicInteger allcount = new AtomicInteger(0);//总数
	private static AtomicInteger failcount = new AtomicInteger(0);//失败个数
	
	
	
	static{
    	executorService = Executors.newFixedThreadPool(100);
    	System.out.println("定时任务公共线程池["+executorService+"]初始化创建成功");
    }
	
	
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		try {
	    	final CountDownLatch latch = new CountDownLatch(1000000);
	    	for(int i=0;i<1000000;i++){
	    		final int a = i;
	    		executorService.execute(new Runnable() {
	    			public void run() {
	    				try {
	    					
	    					allcount.getAndIncrement(); 
	    					if(a%2 == 0){
	    						failcount.getAndIncrement();
	    					}
	    					
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				}finally{
	    					latch.countDown();
	    				}
	    			}
	    		});
	    	}
			latch.await();
			System.out.println("100线程执行结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	System.out.println("allcount="+allcount);
    	System.out.println("failcount="+failcount);
    	System.out.println("耗时："+(System.currentTimeMillis()-beginTime));
    	
    	
    	
    	//下边测试AtomicInteger相减
    	AtomicInteger a1 = new AtomicInteger(10);
    	AtomicInteger a2 = new AtomicInteger(2);
    	System.out.println("a1-a2="+a1.addAndGet(-a2.intValue()));
	}
}

