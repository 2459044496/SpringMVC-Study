package cn.cuiper.controller;

import cn.cuiper.pojo.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/*
* @RestController   由@Controller和@ResponseBody组成（返回json数据格式）
* REST:即Representational State Transfer。（资源）表现层状态转化。
*
* GET：查询
* POST：添加
* PUT：更新
* DELETE：删除
*
* 浏览器form表单只支持GET和POST请求，而DELETE、PUT等method并不支持，Spring3.0添加了一个过滤器，
可以将这些请求转换为标准的http方法，使得支持GET、POST、PUT与DELETE请求。
*/
/*
<filter>
    <filter-name>hiddenHttpMethodFilter</filter-name>
    <filter-class>
        org.springframework.web.filter.HiddenHttpMethodFilter
    </filter-class>
</filter>
<filter-mapping>
    <filter-name>hiddenHttpMethodFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
 */
@RestController
@RequestMapping("/rest")
public class TestRestController {

    // 根据不同的请求方式，执行对应的方法。

    @GetMapping()
    //等价 @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "执行无参get方法。";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id")Integer id) {
        return "执行get :" + id + "方法。";
    }

    @PostMapping()
    // @RequestMapping(method = RequestMethod.POST)
    public String post(@RequestBody(required = false) User user) {
        return "执行post方法。";
    }

    @PutMapping
    public String put() {
        return "执行put方法。";
    }

    @DeleteMapping
    public String delete() {
        return "执行delete方法。";
    }


}
