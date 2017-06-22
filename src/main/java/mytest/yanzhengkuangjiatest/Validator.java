package mytest.yanzhengkuangjiatest;

import mytest.yanzhengkuangjiatest.Rule.AnnotationRule;
import mytest.yanzhengkuangjiatest.Rule.Rule;

/**
 * 通用校验器
 * @author cdwangzijian
 */
public class Validator {
    public Validator validate(Rule rule) {
        if (this.isValid) {
            this.isValid = rule.isValid();
            this.message = rule.getMessage();
        }
        return this;
    }

    public Validator validateAnnotation(Object o) {
        return validate(new AnnotationRule(o));
    }

    public Validator notNull(Object fieldValue, String fieldName) {
        if (this.isValid) {
            if (fieldValue == null) {
                this.isValid = false;
                this.message = fieldName + "不能为空";
            }
        }
        return this;
    }

    /**
     * 是否有效
     * @return
     *         true 校验通过，值有效
     *         message 校验未通过的错误信息
     */
    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }

    private boolean isValid = true; // 是否有效
    private String message; // 错误信息
}
