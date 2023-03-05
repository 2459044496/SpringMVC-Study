package cn.cuiper.databinder.interceptor;
/**
 * 自定义拦截器
 * 1，实现HandlerInterceptor接口
 * 2，实现需要重写的方法，preHandle、postHandle、afterCompletion都是default方法，可以选择实现
 * preHandle
 *      在业务处理器处理请求之前被调用，在该方法中对用户请求request进行处理。
 *      场景：权限控制
 * postHandle
 *      在业务处理器处理完请求后，但是DispatcherServlet向客户端返回响应前被调用，在该方法中对用户请求request进行处理。
 *      场景：对请求域中的属性或视图做出修改。
 * afterCompletion
 *      在DispatcherServlet完全处理完请求后被调用，可以在该方法中进行一些资源清理的操作。
 *      场景：释放资源
 * 3，springmvc.xml配置拦截器
 * <mvc:interceptor>
 *             <!--
 *             /** 拦截所有映射
 *             /* 拦截/开头的映射
 *             /testMyInterceptorController/* 拦截/testMyInterceptorController开头的映射
 *             /test/add* 拦截/test/add开头的映射
 *             /test/*All 拦截/test/All结尾的映射
 *             -->
 *             <mvc:mapping path="/testMyInterceptorController/*"/>
 *             <bean class="cn.cuiper.databinder.interceptor.MyInterceptor"/>
 *         </mvc:interceptor>
 *
 * 执行顺序，controller方法存在异常时，不会执行第（3）步
 * (1),执行preHandle
 * (2),执行controller方法
 * (3),执行postHandle
 * (4),执行afterCompletion
 * */