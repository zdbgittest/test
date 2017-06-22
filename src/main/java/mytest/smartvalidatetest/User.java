package mytest.smartvalidatetest;

import zdybq.Length;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月21日 上午10:36:46
 */
public class User {
    @Length(minLength = 1, maxLength = 10)
    private String name;
    private String address;
    private String memo;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
