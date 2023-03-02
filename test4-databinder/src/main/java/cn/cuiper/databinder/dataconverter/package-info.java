package cn.cuiper.databinder.dataconverter;
/**
 * 自定义converter类型转换器
 * 1，开发类实现org.springframework.core.convert.converter.Converter接口
 * 2，springmvc.xml注册自定义类型转换器
 *     <bean id="myConverter" class="org.springframework.context.support.ConversionServiceFactoryBean">
 *         <property name="converters">
 *             <set>
 *                 <bean class="cn.cuiper.databinder.dataconverter.MyConverter"></bean>
 *             </set>
 *         </property>
 *     </bean>
 * 3，在<mvc:annotation-driven>中声明类型转换器工厂
 * <mvc:annotation-driven conversion-service="myConverter" />
 * */