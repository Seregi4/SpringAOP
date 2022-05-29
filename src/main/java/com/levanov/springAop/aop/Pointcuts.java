package com.levanov.springAop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

   @Pointcut("execution(* com.levanov.springAop.service.BookService.get*(..))")
   public void allGetMethods(){}

    @Pointcut("execution(* com.levanov.springAop.service.BookService.add*(..))")
    public void allAddMethods(){}

}
