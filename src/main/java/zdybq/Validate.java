package zdybq;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月21日 上午11:03:05
 */
public class Validate {
    public boolean validate(Object t) throws Exception {
        Class classz = t.getClass();
        Field[] fieldArr = classz.getFields();
        for (Field f : fieldArr) {
            Annotation[] anArr = f.getAnnotations();
            List<Annotation> list = Arrays.asList(anArr);
            if (!list.contains(Validation.class)) {
                continue;
            }
            f.setAccessible(true);
            Object fieldValue = f.get(t);
            for (Annotation an : list) {
                String typeName = an.annotationType().toString();
                switch (ValidateType.valueOf(typeName)) {
                    case Length:
                        return validateLength(fieldValue.toString(), (Length) an);
                }
            }
        }
        return true;
    }

    public static boolean validateLength(String str, Length length) {
        int maxLength = length.maxLength();
        int minLength = length.minLength();
        if (str.length() < minLength) {
            return false;
        }
        if (str.length() > maxLength) {
            return false;
        }
        return true;
    }
}
