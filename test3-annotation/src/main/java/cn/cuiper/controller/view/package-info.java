package cn.cuiper.controller.view;

/*
* 自定义视图
*
* 1，编写类实现View接口，并使用@Component注解
* 2，controller返回视图，视图名为类名小写,@Component注解放入Spring容器中默认命名规则
* 3，配置视图解析器
* <bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
*    <property name="order" value="100" />
* </bean>
* */