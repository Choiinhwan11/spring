package Chapter03_XML.sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통관심사항
public class LoggingAdvice {
    public void beforeTrace(){
        System.out.println("before trace");
    }

    public void afterTrace(){
        System.out.println("after trace");
    }

    //ProceedingJoinPoint = applicationcontext 로 부터 받은 것을 조합 하기 위해서 필요 하다 .
    public void trace(ProceedingJoinPoint joinPoint) throws Throwable{
        // 앞에 삽입될 코드
        //System.out.println("하늘");
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("메소드 = " + methodName);

        //실행 시간을 측정하는 단계이다 .
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        // 핵심코드 메소드를 호출
        //오블젝트에 저장을 위해서 만들어 졌다 .
        Object ob =  joinPoint.proceed();
        System.out.println(ob);
        // 뒤에 삽입될 코드
        //System.out.println("땅");

        stopWatch.stop();
        System.out.println("처리 시간 = " + stopWatch.getTotalTimeMillis()/1000 + "초");
        //getTotaltimeMillis 시간 초를 나타내는 것이다.
    }
}
