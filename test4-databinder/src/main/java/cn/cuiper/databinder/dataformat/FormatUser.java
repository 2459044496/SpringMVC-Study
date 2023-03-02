package cn.cuiper.databinder.dataformat;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Data
public class FormatUser {

    private String name;

    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,###")
    private Integer age;

    // 格式化前端到后台的数据 Spring的注解
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    // 格式化后端返回的格式 jackson的注解
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
}
