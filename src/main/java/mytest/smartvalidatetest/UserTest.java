package mytest.smartvalidatetest;

import zdybq.Validate;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月21日 上午10:36:55
 */
public class UserTest {
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        User u = new User();
        u.setName("111111111111111111111111111111111111");
        Validate v = new Validate();
        System.out.println(v.validate(u));
    }
}
