package mytest.myzj;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月21日 下午1:43:04
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        Validate v = new Validate();
        s.setName("姓名");
        s.setAge(1);
        s.setAddress("地址");
        s.setMome("备注");
        Result result = v.check(s);
        System.out.println(result.isSuccess());
        System.out.println(result.getErrorCode() + "-----" + result.getErrorMsg());
    }
}
