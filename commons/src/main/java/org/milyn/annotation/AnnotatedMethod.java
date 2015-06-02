// Copyright 2007 Fusionsoft, Inc. All rights reserved.
// Use is subject to license terms.
package org.milyn.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public interface AnnotatedMethod {
	/**
	 * @return the annotated class where the method is declared.
	 */
	AnnotatedClass getAnnotatedClass();

	/**
	 * @return the method wrapped by the annotated method.
	 */
	Method getMethod();

	/**
	 * Returns true if an annotation for the specified type is present on this element, else false.
	 *
	 * @param annotationClass the Class object corresponding to the annotation type
	 * @return true if an annotation for the specified annotation type is present on this element, else false
	 */
	boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);


	/**
	 * @return all inherited and declared annotations of the method.
	 */
	Annotation[] getAllAnnotations();

	<T extends Annotation> T getAnnotation(Class<T> annotationClass);

	Annotation[][] getParameterAnnotations();
}
