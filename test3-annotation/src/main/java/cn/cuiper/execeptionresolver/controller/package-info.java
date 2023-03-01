package cn.cuiper.execeptionresolver.controller;

//1，DefaultHandlerExceptionResolver，默认的异常处理器。根据各个不同类型的异常，返回不同的异常视图。

/*2，SimpleMappingExceptionResolver，简单映射异常处理器。通过配置异常类和view的关系来解析异常。
 * （1）xml配置SimpleMappingExceptionResolver异常处理器
<!--配置SimpleMappingExceptionResolver异常处理器-->
<bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver" >
<!-- 定义异常处理页面用来获取异常信息的变量名，默认名为exception -->
<property name="exceptionAttribute" value="ex"/>
<property name="exceptionMappings">
<props>
<!-- 指定异常跳转的错误视图 -->
<prop key="java.lang.ArrayIndexOutOfBoundsException">simpleMappigExceptionResolver</prop>
<prop key="java.lang.NullPointerException">simpleMappigExceptionResolver</prop>
</props>
</property>
</bean>
*/

/*3，ResponseStatusExceptionResolver，状态码异常处理器。解析带有@ResponseStatus注释类型的异常。
* （1）作用在异常类上，若ExceptionHandlerExceptionResolver不解析该异常，则由于触发的异常会被ResponseStatusExceptionResolver解析到
* 最后响应@reponseStatus的值HttpStatus.UNAUTHORIZED代码给客户端。在客户端便能看到HttpStatus.UNAUTHORIEZD代表的401响应码，并将注解中的出错原因显示到页面。
* （2）作用在方法上，修饰的方法会正常执行，但最终响应给客户端的响应码为@ResponseStatus中的响应码。
* */


/*ExceptionHandlerExceptionResolver，注解形式的异常处理器。对@ExceptionHandler注解的方法进行异常解析。
 * （1）如果只在controller类中，则只作用与该类。
 * （2）可以定义全局范围。类使用@ControllerAdvice，方法再使用@ExceptionHandler
 */

/*自定义异常处理类。
 *1，自定义异常，继承Exception类。
 *2，自定义异常处理类，实现HandlerExceptionResolver接口。
 *3，配置到IOC中
*/