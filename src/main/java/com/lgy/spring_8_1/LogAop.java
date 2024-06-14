package com.lgy.spring_8_1;

import org.aspectj.lang.ProceedingJoinPoint;

//공통기능 클래스(Aspect)
public class LogAop {
//	loggerAop: advice(공통기능 자체-메소드)
//	joinPoint : 핵심기능(공통기능이 적용되는 대상-메소드)
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
//		getSignature().toLongString() : 핵심기능 클래스의 메소드 정보를 가지고 옴
		String signatureStr = joinPoint.getSignature().toLongString();
//		핵심기능이 start 되었다.(공통기능 실행(advice))
		System.out.println(signatureStr+"is start.");
		long st = System.currentTimeMillis();
		Object obj=null;
		
//		*.1번방식
		/*
		try {
			//핵심기능 실행
			obj = joinPoint.proceed();//예외처리 추가
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			long et = System.currentTimeMillis();			
			System.out.println(signatureStr+"is finished.");
			System.out.println(signatureStr+"의 경과시간 : "+(et - st));
		}
		
		
		return obj; //핵심기능 반환
		*/
		
//		*.2번 방식
		try {
			//핵심기능 실행
			obj = joinPoint.proceed();//예외처리 추가
			return obj; //핵심기능 반환
		} finally {
			long et = System.currentTimeMillis();			
			System.out.println(signatureStr+"is finished.");
			System.out.println(signatureStr+"의 경과시간 : "+(et - st));
		}
	}
}
