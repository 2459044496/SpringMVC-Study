package cn.cuiper.execeptionresolver.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exceptionHandler")
public class ExceptionHandlerController {

    /** 默认情况下，@ExceptionHandler注解的方法只能处理当前Controller类内部handler产生的异常。
     *
     * 如需定义全局的@ExceptionHandler异常处理，可以单独定义一个异常处理类，使用ControllerAdvice注解该类，
     * 在该类中编写@ExceptionHandler处理方法。
     *
     * 如果在当前controller中找不到@ExceptionHandler方法来处理handler出现的异常，则将去@ControllerAdvice注解的类中查找@ExceptionHandler来处理异常。
     */
    @ExceptionHandler({ArithmeticException.class, Exception.class})
    public String handleExceptionArithmeticException(Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        return "异常信息为:" + e.getMessage();
    }

    @GetMapping("/getInfo")
    public String getInfo() {
        int i = 1 / 0;
        return "success";
    }
}
