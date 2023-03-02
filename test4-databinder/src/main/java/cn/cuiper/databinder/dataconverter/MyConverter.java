package cn.cuiper.databinder.dataconverter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class MyConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        System.out.println("执行MyConverter.convert()方法，入参为:" + source);
        if (!StringUtils.isEmpty(source)) {
            return Integer.valueOf(source);
        }
        return null;
    }
}
