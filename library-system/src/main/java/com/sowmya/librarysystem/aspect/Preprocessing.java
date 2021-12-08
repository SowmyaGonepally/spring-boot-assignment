package com.sowmya.librarysystem.aspect;

import com.sowmya.librarysystem.dto.BookDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.logging.Logger;

@Aspect
@Component
public class Preprocessing {

    private final Logger logger = Logger.getLogger(Preprocessing.class.getName());

    //an advice for preprocessing book's name as First letter capital and remaining letters as small
    @Around("execution(String com.sowmya.librarysystem.controller.BookController.saveBook(..))")
    public Object beforeAddAccountAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
       int index=0;
       Object[] modifiedArgs=proceedingJoinPoint.getArgs();
       for(Object arg:proceedingJoinPoint.getArgs())
       {
           if(arg instanceof BookDto)
           {
               BookDto bookDto=(BookDto)arg;
               String originalName=bookDto.getName();
               String modifiedName=originalName.substring(0,1).toUpperCase(Locale.ROOT)+originalName.substring(1).toLowerCase(Locale.ROOT);
               BookDto modifiedBookDto=new BookDto(modifiedName, bookDto.getAuthor(), bookDto.getQuantity(), bookDto.getCategory());
               modifiedBookDto.setId(bookDto.getId());
               modifiedArgs[index]=modifiedBookDto;
               logger.info("------ADVICE EXECUTING------");
           }
           index++;
       }
       return proceedingJoinPoint.proceed(modifiedArgs);

    }


}
