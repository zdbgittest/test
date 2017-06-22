package mytest.myzj;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月21日 下午1:32:48
 */
public class Student {
    @NotEmpty
    private String name;
    @NotEmpty
    private Integer age;
    @NotEmpty
    private String address;
    @NotEmpty
    private String mome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMome() {
        return mome;
    }

    public void setMome(String mome) {
        this.mome = mome;
    }
}
