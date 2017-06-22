package mytest.test;

import mytest.yanzhengkuangjiatest.Validator;
import mytest.yanzhengkuangjiatest.Rule.AnnotationRule;

public class TestValidator {
    public static void main(String[] args) {
        new Validator().validate(new AnnotationRule(new User()));
    }
}
