package wlg.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAdvice {
  /**
   * 执行方法前拦截器
   * 
   * @param joinPoint
   */
  public void methodBefore(JoinPoint joinPoint) {
    System.out.println(joinPoint.getTarget().getClass().getName() + "."
                       + joinPoint.getSignature().getName()
                       + " Start");
  }

  /**
   * 方法执行后拦截器
   * 
   * @param joinPoint
   */
  public void methodAfter(JoinPoint joinPoint) {
    System.out.println(joinPoint.getTarget().getClass().getName() + "."
                       + joinPoint.getSignature().getName()
                       + " end");
  }

  /**
   * 方法出现异常拦截器
   * 
   * @param joinPoint
   */
  public void methodException(JoinPoint joinPoint) {
    System.out.println(joinPoint.getTarget().getClass().getName() + "."
                       + joinPoint.getSignature().getName()
                       + " mett Error");
  }

  /**
   * 方法环绕拦截器，如果使用了这个，可以忽视上面的方法 注意该方法参数为ProceedingJoinPoint ，
   * 这是可以执行的，只有round可以使用
   * 
   * @param joinPoint
   * @return
   */
  public Object methodRound(ProceedingJoinPoint joinPoint) {
    methodBefore(joinPoint);
    Object ob = null;
    try {
      ob = joinPoint.proceed();
    } catch (Throwable error) {
      methodException(joinPoint);
    }
    methodAfter(joinPoint);
    return ob;
  }
}
