// Copyright 2007 Fusionsoft, Inc. All rights reserved.
// Use is subject to license terms.
package org.milyn.annotation;

import java.util.HashMap;
import java.util.Map;

public class AnnotationManager {
	private static Map<Class<?>, AnnotatedClass> classToAnnotatedMap = new HashMap<Class<?>, AnnotatedClass>();

	/**
	 * @param theClass to wrap.
	 * @return the annotated class wrapping the specified one.
	 */
	public static AnnotatedClass getAnnotatedClass(Class<?> theClass){
		AnnotatedClass annotatedClass = classToAnnotatedMap.get(theClass);
		if (annotatedClass == null){
			annotatedClass = new AnnotatedClassImpl(theClass);
			classToAnnotatedMap.put(theClass, annotatedClass);
		}
		return annotatedClass;
	}
}
