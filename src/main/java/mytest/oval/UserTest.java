package mytest.oval;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月20日 下午3:29:37
 */
public class UserTest {
    public static void main(String[] args) {
        Validator validator = new Validator();
        User user = new User();
        user.setName("111111111111");
        user.setAddress("");
        user.setCreateTime("2015-01-01 01:11:89");
        user.setUpdateTime("2015-02-29 01:11:61");
        List<ConstraintViolation> message = validator.validate(user);//完全验证
        System.out.println(message.toString());
    }
}
