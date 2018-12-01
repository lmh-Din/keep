package com.example.config.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;

/**
 * @Description
 * @ClassName AopLogDefinition
 * @Author Liumh
 * @Date 2018/11/1 15:14
 * @Version v1.0
 */
@Slf4j
@Aspect
@Component
public class AopLogDefinition {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Long beforCurrentTime = 0L;

    private Long afterCurrentTime = 0L;


    @Pointcut("@annotation(com.example.config.annotation.AopLog)")
    public void pointCut(){}

    @Around("pointCut()")
    public void doAround(ProceedingJoinPoint pjp){
        Object[] args = pjp.getArgs();
        Object[] args2 = new Object[args.length];
        for (int i=0;i<args.length;i++) {
            String instanceName = args[i].getClass().getSimpleName();
            if (instanceName.contains("String")){
                args2[i]="String text";
            }else {
                args2[i]=args[i];
            }
        }
        try {
            pjp.proceed(args2);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    /*@Before("pointCut()")
    public void doBefore(JoinPoint jp){
        log.info("***********METHOD : {}__{}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName());
        String requestParams = parseParams(jp.getArgs());
        log.info("***********Params:{}", requestParams);
    }


    private String parseParams(Object[] objects){
        StringBuffer paramsStr = new StringBuffer("{ ");
        if (objects.length > 0){
            for (Object obj:objects) {
                paramsStr.append(obj.getClass().getSimpleName()).append(" : ").append(obj);
                paramsStr.append(" , ");
            }
            paramsStr = new StringBuffer(paramsStr.substring(0, paramsStr.length()-2));
        }
        paramsStr.append("}");
        return paramsStr.toString();
    }*/

    /*@AfterReturning("pointCut()")
    public void afterReturning(JoinPoint jp){
        log.info("************execute Method afterReturning");
    }*/

    /*@AfterThrowing("pointCut()")
    public void afterThrowing(JoinPoint jp){
        log.info("************execute Method afterThrowing");
    }*/

    @After("pointCut()")
    public void doAfter(JoinPoint jp){

    }

}
