package fx.leyu.notes.aop;

import fx.leyu.notes.common.log.LogUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeMonitor.class);

    @Around("execution(* *(..))")
    public Object logControllerTimeSpent(ProceedingJoinPoint joinPoint) {
        LOGGER.debug("[MONITOR] start");
        long start = System.currentTimeMillis();
        try {
            Object obj = joinPoint.proceed();
            LogUtils.debug(LOGGER, "[MONITOR] time spent is {}", () -> System.currentTimeMillis() - start);
            LOGGER.debug("[MONITOR] the result object is {}", obj);
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
