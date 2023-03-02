package cn.cuiper.databinder.initbinder;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
// 全局使用@InitBinder
public class MyInitBinderAdvice {

    @InitBinder
    public void useInitBinder(WebDataBinder binder) {
        // 绑定javabean属性时，不绑定xxx属性
        // binder.setDisallowedFields();
        // 对于Date类型的参数会先格式化在绑定
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }
}
