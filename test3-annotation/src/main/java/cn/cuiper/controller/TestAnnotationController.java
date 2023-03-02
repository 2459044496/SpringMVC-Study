package cn.cuiper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

@Controller
@RequestMapping("testAnnotation")
public class TestAnnotationController {

    /**
    *常用注解	作用
    *@RestController	由 @Controller + @ResponseBody组成（返回 JSON 数据格式）
    *@PathVariable	URL 中的 {xxx} 占位符可以通过@PathVariable(“xxx“) 绑定到控制器处理方法的形参中
    *@RequestMapping	注解用于请求地址的解析，是最常用的一种注解
    *@GetMapping	查询请求
    *@PostMapping	添加请求
    *@PutMapping	更新请求
    *@DeleteMapping	删除请求
    *@RequestParam	将请求参数绑定到你控制器的方法参数上（是springmvc中接收普通参数的注解）
    */

    /* @RequestParam
    * 使用范围： 形参
    * 属性：
    *   value：请求参数的名称
    *   name：同value属性
    *   required：请求参数中必须提供该参数，默认为true。
    *   defaultValue：默认值
    * */
    @RequestMapping("teRequestParam")
    public String teRequestParam(@RequestParam("userName")String name,
            @RequestParam(value = "age", required = false)Integer age,
            @RequestParam(value = "remark", defaultValue = "备注")String remark) {
        System.out.println("userName参数值为:" + name);
        System.out.println("age参数值为:" + age);
        System.out.println("remark参数值为:" + remark);
        return "default";
    }


    /* @RequestBody  使用需要导入json序列化依赖，例如jackson
     * 接收JSON格式报文
     * 使用范围： 形参
     * get请求不适用该注解
     * 属性：
     *   required：请求参数中必须提供该参数，默认为true。
     * */
    @RequestMapping(value = "teRequestBody", method = RequestMethod.POST)
    public String teRequestBody(@RequestBody String body) {
        System.out.println("body参数值为:" + body);
        return "default";
    }

    /* @PathVariable
     * 参考链接 https://www.baeldung.com/spring-pathvariable
     * 使用范围： 形参
     * 绑定url中的占位符。
     * url支持占位符是Spring3.0之后加入的，是SpringMVC支持rest风格URL的一个重要标志
     * 属性：
     *   value：指定url中占位符的名称
     *   name：同value属性
     *   required：请求参数中必须提供该参数，默认为true。   需要结合@RequestMapping value数组，配置多个url
     * */
    @RequestMapping(value = "tePathVariable1/{id}")
    public String tePathVariable1(@PathVariable(value = "id", required = false) Integer id) {
        System.out.println("tePathVariable1 id参数值为:" + id);
        return "default";
    }

    @RequestMapping(value = "tePathVariable2/{id}/{name}")
    public String tePathVariable2(
            // 这里虽然id配置了非必填，但是该接口没有配置tePathVariable2/{name}路径，会404
            @PathVariable(value = "id", required = false) Integer id,
                                  @PathVariable("name")String name) {
        System.out.println("tePathVariable2 id参数值为:" + id);
        System.out.println("tePathVariable2 name参数值为:" + name);
        return "default";
    }

    @RequestMapping(value = "tePathVariable3/{id}/{name}")
    public String tePathVariable3(@PathVariable Map<String, Object> params) {
        System.out.println("tePathVariable3 params参数值为:" + params);
        for (String s : params.keySet()) {
            System.out.println("key is:" + s + ";values is:" + params.get(s));
        }
        return "default";
    }

    @RequestMapping(value = {"tePathVariable4/{id}", "tePathVariable4"})
    public String tePathVariable4(@PathVariable(value = "id", required = false) Integer id) {
        if (id == null) {
            System.out.println("tePathVariable4 未接收到url中id参数");
        } else {
            System.out.println("tePathVariable4 id参数值为:" + id);
        }
        return "default";
    }

    @RequestMapping("/teRequestHeader")
    @ResponseBody// 返回 JSON 数据格式，不再是ModuleAndView
    public String teRequestHeader(@RequestHeader(value = "User-Agent", required = false,
            defaultValue = "我是默认值")String headInfo) {
        return headInfo;
    }

    @RequestMapping("/teCookieValue")
    @ResponseBody// 返回 JSON 数据格式，不再是ModuleAndView
    // Cookie参数在请求头中格式为
    // Cookie: JSESSIONID=XXXXX
    // 其他请求头格式为:    请求头名：请求头值
    public String teCookieValue(@CookieValue(value = "JSESSIONID", required = false,
            defaultValue = "我是默认值")String sessionId) {
        return sessionId;
    }


    /*
    * @ModelAttribute
    * 应用在方法上  先执行@ModelAttribute注解修饰的方法
    * 应用在方法的参数上  调用方法时，模型的值会被注入。这在实际使用时非常简单，常用于将表单属性映射到模型对象（参数为对象）。
    * 应用在方法上，并且方法也使用了 @RequestMapping。  方法的返回值会存入到 Model 对象中，key 为 ModelAttribute 的 value 属性值。
方法的返回值不再是方法的访问路径，访问路径会变为 @RequestMapping 的 value 值，例如：@RequestMapping(value = "/index") 跳转的页面是 index.jsp 页面。
    * */
    @ModelAttribute
    public void exeModelAttribute() {
        System.out.println("执行@ModelAttribute注解修饰的方法");
    }

    @RequestMapping("/teModelAttribute")
    @ResponseBody
    public String teModelAttribute() {
        return "123";
    }

}
