package cn.cuiper.databinder.datavalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// 自定义参数校验类，校验String字段为IPv4地址格式
public class IpCheckValidator implements ConstraintValidator<IpCheck, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("校验ip地址，参数为:" + s);
        String split[] = s.split("\\.");
        if(split.length==4){
            int ipArrayInt[] = new int[4];
            for (int i=0;i<4;i++){
                try {
                    ipArrayInt[i]=Integer.parseInt(split[i]);
                } catch (Exception e){
                    return false;
                }
            }
            if(ipArrayInt[0]>=1&&ipArrayInt[0]<=255)
                for (int j=1;j<4;j++){
                    if(ipArrayInt[j]<0||ipArrayInt[j]>255){
                        return false;
                    }
                }
            return  true;
        }
        return false;
    }
}
