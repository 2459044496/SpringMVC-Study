package cn.cuiper.databinder.datavalidator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/testValidatorController")
public class TestValidatorController {

    //@Valid和@Validated比较：
    //@Valid : JSR(javax) 没有分组功能，可以在方法、构造函数、方法参数和成员属性上。如果一个待验证的pojo类，其中还包含了待验证的对象，需要在待验证对象上注解@Valid才能验证待验证对象中的成员属性。

    //@Validated：Spring 提供分组功能，可以在入参验证时，根据不同的分组采用不同的验证机制，用在类型、方法和方法参数上，但不能用于成员属性上。

    @RequestMapping("/test")
    // @Validated后要紧跟 BindingResult参数
    public String test(@Valid Obj obj, BindingResult bindingResult) {
        if (bindingResult.getErrorCount() > 0) {
            StringBuilder sb = new StringBuilder();
            System.out.println("数据绑定出现错误: ");
            for (ObjectError allError : bindingResult.getAllErrors()) {
                sb.append(allError.getDefaultMessage()).append("\n");
            }
            System.out.println(sb);
            return sb.toString();
        }
        return "success";
    }

}
