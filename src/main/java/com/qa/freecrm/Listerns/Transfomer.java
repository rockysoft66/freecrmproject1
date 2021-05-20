package com.qa.freecrm.Listerns;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Transfomer implements IAnnotationTransformer {

	
	public void transform(ITestAnnotation annotation, Class ClassName, Constructor classConst, Method ClassMethod) {
		
		annotation.setRetryAnalyzer(RetryAnalzer.class);
	}

}
