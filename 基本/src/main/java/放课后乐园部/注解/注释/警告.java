package 放课后乐园部.注解.注释;

import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.CLASS)

public @interface 警告 {
		String value();
}
