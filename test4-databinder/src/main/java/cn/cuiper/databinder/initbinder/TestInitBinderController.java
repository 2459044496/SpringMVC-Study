package cn.cuiper.databinder.initbinder;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/testInitBinderController")
public class TestInitBinderController {

    // 这里的@InitBinder方法只对当前Controller生效，要想全局生效，可以使用@ControllerAdvice。
    // 或者使用RequestMappingHandlerAdapter：

    @Bean
    public RequestMappingHandlerAdapter webBindingInitializer() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        adapter.setWebBindingInitializer(new WebBindingInitializer(){

            @Override
            public void initBinder(WebDataBinder webDataBinder) {
                webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
            }
        });
        return adapter;
    }

    @InitBinder
    public void useInitBinder(WebDataBinder binder) {
        // 绑定javabean属性时，不绑定xxx属性
        // binder.setDisallowedFields();
        // 对于Date类型的参数会先格式化在绑定
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @RequestMapping("/getUser")
    public String getUser(@RequestParam String name, @RequestParam Date date) {
        System.out.println("name:" + name);
        System.out.println("date:" + date);
        return date.toString();
    }
}
