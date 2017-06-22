package zdybq;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailto:amoszhou@foxmail.com">amos zhou</a>
 * @Function：验证长度
 * @Since Aug 24, 2011
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {

    int minLength();

    int maxLength();

}
