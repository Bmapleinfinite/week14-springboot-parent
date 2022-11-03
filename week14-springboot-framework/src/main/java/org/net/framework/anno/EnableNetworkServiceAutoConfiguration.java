package org.net.framework.anno;

import org.net.framework.auto.NetworkServiceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({NetworkServiceAutoConfiguration.class})
public @interface EnableNetworkServiceAutoConfiguration {
}
