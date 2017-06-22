package mytest.yanzhengkuangjiatest.Rule;

import mytest.yanzhengkuangjiatest.AnnotationValidator;
import mytest.yanzhengkuangjiatest.annotation.parser.ValidateResult;

/**
 * 使用AnnotationValidator的校验规则
 * @see AnnotationValidator
 * @author cdwangzijian
 */
public class AnnotationRule implements Rule {
    private String message;
    private Object o;

    public AnnotationRule(Object o) {
        this.o = o;
    }

    public String getMessage() {
        return message;
    }

    public boolean isValid() {
        ValidateResult result = AnnotationValidator.validate(this.o);
        this.message = result.getMessage();
        return result.isValid();
    }

}
