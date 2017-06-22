package mytest.yanzhengkuangjiatest;

import java.lang.reflect.Field;

import mytest.yanzhengkuangjiatest.annotation.NotBlank;
import mytest.yanzhengkuangjiatest.annotation.parser.IAnnotationParser;
import mytest.yanzhengkuangjiatest.annotation.parser.ValidateResult;

/**
 * @author zhangdb@uubee.com
 * @date 2017年6月19日 上午10:36:30
 *
 */
/**
 * 不能为空白校验器
 * @author cdwangzijian
 */
public class NotBlankParser implements IAnnotationParser {

    /**
     * 校验字段f的值不能为null或者是空字符串，校验结果保存在result中
     */
    public ValidateResult validate(Field f, Object value) {
        ValidateResult result = new ValidateResult();
        if (f.isAnnotationPresent(NotBlank.class)) {
            NotBlank notBlank = f.getAnnotation(NotBlank.class);
            if (value == null || value.toString().length() == 0) {
                result.setMessage(notBlank.fieldName() + "不能为空");
            }
        }
        return result;
    }

}
