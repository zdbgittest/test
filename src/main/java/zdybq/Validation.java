package zdybq;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailto:amoszhou@foxmail.com">amos zhou</a>
 * @Function：用来标识需要验证
 * @Since Aug 24, 2011
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validation {

}
