package cn.cuiper.execeptionresolver.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "用户未注册")
/**
 * 若在处理器方法中出现了这个异常：若ExceptionHandlerExceptionResolver不解析该异常，
 * 则由于触发的异常会被ResponseStatusExceptionResolver解析到。
 * 最后响应@reponseStatus的值HttpStatus.UNAUTHORIZED代码给客户端。
 * 在客户端便能看到HttpStatus.UNAUTHORIEZD代表的401响应码，并将注解中的出错原因显示到页面。
 *
 * @ResponseStatus注解可以修饰类，也可以修饰方法。修饰方法时，修饰的方法会正常执行，但最终响应给客户端的响应码为@ResponseStatus中的响应码。
 * */
public class MyUnauthorizedException extends Exception{
}
