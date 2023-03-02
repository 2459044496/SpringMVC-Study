package cn.cuiper.databinder.datavalidator;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;


@Data
public class Obj {

    @Min(value = 10, message = "最小值是10")
    private Integer min;

    //@NotEmpty(message = "aa不能为null")
    private String aa;
}
