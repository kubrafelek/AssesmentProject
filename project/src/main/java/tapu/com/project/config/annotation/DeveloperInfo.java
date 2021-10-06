package tapu.com.project.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface DeveloperInfo {
    public enum Expertise {
        JUNIOR, MID, SENIOR, LEAD
    }

    Expertise expertise() default Expertise.JUNIOR;
    String url() default "https://github.com/kubrafelek";
    String createdBy();
    String email() default "kubra.felek@isik.edu.tr";
}
