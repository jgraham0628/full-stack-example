package gal.imperial.navy.aspect;

//import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import gal.imperial.navy.annotation.FeatureToggle;


@Interceptor
@FeatureToggle
public class FeatureToggleAspect {

	@AroundInvoke
	public Object featureCheck(InvocationContext invocationCtx) throws Exception {
		long startTime = System.currentTimeMillis();
        //execute the intercepted method and store the return value
        Object returnValue = invocationCtx.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Latency of " + invocationCtx.getMethod().getName() +": " + (endTime-startTime)+"ms");
        return returnValue;
	}
	
	
	
//	public void logBefore(ProceedingJoinPoint joinPoint) throws Throwable{
//		boolean lockedDown = false;
//		
//		if (joinPoint.getTarget().getClass().isAnnotationPresent(FeatureToggle.class)) {
//			lockedDown = joinPoint.getTarget().getClass().getAnnotation(FeatureToggle.class).lockedDown();
//			
//			if (lockedDown) {
//				System.out.println("Go fuck yourself at the class level");
//			} else {
//				System.out.println("logAround() with no class lock down is running!");
//				System.out.println("hijacked : " + joinPoint.getSignature().getName());
//				System.out.println("******");
//				joinPoint.proceed();
//			}
//		} else {
//			Method calling = joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName());
//			if (calling.isAnnotationPresent(FeatureToggle.class)) {
//				lockedDown = calling.getAnnotation(FeatureToggle.class).lockedDown();
//				
//				if (lockedDown) {
//					System.out.println("Go fuck yourself at the method level");
//				}
//				else {
//					System.out.println("logAround() with no method lock down is running!");
//					System.out.println("hijacked : " + joinPoint.getSignature().getName());
//					System.out.println("******");
//					joinPoint.proceed();
//				}
//			}
//		}
//	}

}	
