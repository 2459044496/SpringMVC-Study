package cn.cuiper.execeptionresolver.controller;

//DefaultHandlerExceptionResolver，默认的异常处理器。根据各个不同类型的异常，返回不同的异常视图。
//SimpleMappingExceptionResolver，简单映射异常处理器。通过配置异常类和view的关系来解析异常。
//ResponseStatusExceptionResolver，状态码异常处理器。解析带有@ResponseStatus注释类型的异常。
//ExceptionHandlerExceptionResolver，注解形式的异常处理器。对@ExceptionHandler注解的方法进行异常解析。
//自定义异常解析类。1，自定义异常，继承Exception类。2，自定义异常解析类，实现HandlerExceptionResolver接口。3，配置到IOC中