package cn.cuiper.databinder.datavalidator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/testValidatorController")
public class TestValidatorController {

    @RequestMapping("/test")
    // @Todo 参数验证
    public String test(@Validated Obj obj, BindingResult bindingResult) {
        if (bindingResult.getErrorCount() > 0) {
            StringBuilder sb = new StringBuilder();
            System.out.println("数据绑定出现错误: ");
            for(FieldError error : bindingResult.getFieldErrors()) {
                sb.append("[" + error.getField() + "] : " + error.getDefaultMessage());
            }
            return sb.toString();
        }
        return "success";
    }

}
