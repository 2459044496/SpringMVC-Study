package cn.cuiper.databinder.datavalidator;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class Obj {

    @Min(value = 10, message = "min最小值是10")
    private Integer min;

    @NotNull(message = "aa不能为null")
    private String aa;

    @Email(message = "邮箱填写错误")
    private String email;

    @Length(min = 0, max = 150, message = "年龄必须是0~150岁")
    private String age;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @IpCheck(message = "ip地址填写错误")
    private String ip;
}
