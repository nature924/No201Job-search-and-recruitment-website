package cn.jia.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public String handlerException(){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("err");
        return "err";
    }
}
