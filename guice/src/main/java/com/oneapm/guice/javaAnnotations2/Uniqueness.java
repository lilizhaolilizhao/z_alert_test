package com.oneapm.guice.javaAnnotations2;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique=true);
}
