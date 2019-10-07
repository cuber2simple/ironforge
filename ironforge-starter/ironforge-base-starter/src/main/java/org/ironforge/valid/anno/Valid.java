package org.ironforge.valid.anno;

import org.ironforge.valid.ValidExec;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Valid {
     Class<? extends ValidExec> exec();
}
