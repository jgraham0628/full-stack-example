package gal.imperial.navy.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

@Inherited
@InterceptorBinding
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface FeatureToggle {
	
	/**
	 * Pass in a true value if you want to prevent all access to the class or method that this annotation is a part of
	 * @return true is the class or method is on complete lock down, false if it can be accessed by the certified listing
	 */
	boolean lockedDown() default false;
	
	/**
	 * Pass in all annotations that are an extension of the [] enumeration.
	 * @return the listing of all the certified access permissions that are allowed to access the class or method
	 */
	@Nonbinding
	Access[] certifiedAccess() default Access.NONE;
}
