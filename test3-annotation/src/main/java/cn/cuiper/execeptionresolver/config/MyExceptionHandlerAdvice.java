package cn.cuiper.execeptionresolver.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
// 全局异常处理类，可以定义多个方法处理指定的异常
public class MyExceptionHandlerAdvice {

    @ExceptionHandler({ArithmeticException.class})
    public String handleExceptionArithmeticException(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        return "异常信息为:" + e.getMessage();
    }

    @ExceptionHandler({NullPointerException.class})
    public String handleNullPointException(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        return "异常信息为:" + e.getMessage();
    }

    /*@ExceptionHandler({Exception.class})
    public String handleException(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        return "异常信息为:" + e.getMessage();
    }*/
}
