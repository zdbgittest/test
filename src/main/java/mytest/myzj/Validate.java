package mytest.myzj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月21日 下午1:40:35
 */
public class Validate {
    private final String NotEmptyName = "interface mytest.myzj.NotEmpty";
    private final String MustDateName = "interface mytest.myzj.MustDate";
    private final String MustDateTimeName = "interface mytest.myzj.MustDateTime";

    public Result check(Object bean) throws IllegalArgumentException, IllegalAccessException {
        Result result = new Result();

        Class c = bean.getClass();
        //        System.out.println(c);
        Field[] fields = c.getDeclaredFields();
        //        for (Field f : fields) {
        //            System.out.println(f);
        //        }

        //遍历所有的属性
        for (Field field : fields) {
            //打印属性信息，包括访问控制修饰符，类型及属性名
            //            System.out.println(field);
            //            System.out.println("修饰符：" + Modifier.toString(field.getModifiers()));
            //            System.out.println("类型：" + field.getType());
            //            System.out.println("属性名：" + field.getName());
            //            System.out.println(field.getAnnotation(NotEmpty.class));
            //            System.out.println(field.toGenericString());
            //获取字段值
            //            field.setAccessible(true);
            //            System.out.println(field.getName() + ":" + field.get(bean));
            Annotation[] anArr = field.getAnnotations();
            List<Annotation> list = Arrays.asList(anArr);
            field.setAccessible(true);
            for (Annotation a : list) {
                String typeName = a.annotationType().toString();
                //                System.out.println("typeName=" + typeName);
                //                System.out.println(NotEmpty.class.toString().equals(typeName));
                switch (typeName) {
                    case NotEmptyName:
                        result = NotEmptyMethod(field, field.get(bean));
                        if (!result.isSuccess()) {
                            return result;
                        }
                        break;
                    case MustDateName:
                        result = NotEmptyMethod(field, field.get(bean));
                        if (!result.isSuccess()) {
                            return result;
                        }
                        break;
                    case MustDateTimeName:
                        result = NotEmptyMethod(field, field.get(bean));
                        if (!result.isSuccess()) {
                            return result;
                        }
                        break;
                }
            }
        }
        return result;
    }

    public Result NotEmptyMethod(Field field, Object obj) {
        Result result = new Result();
        if (obj == null) {
            result.setError("99999", field.getName() + "不能为空");
            return result;
        }
        String fieldValue = obj.toString();
        if (fieldValue == null || "".equals(fieldValue)) {
            result.setError("99999", field.getName() + "不能为空");
            return result;
        }
        return result;
    }

    public Result MustDateMethod() {
        Result result = new Result();
        return result;
    }

}
