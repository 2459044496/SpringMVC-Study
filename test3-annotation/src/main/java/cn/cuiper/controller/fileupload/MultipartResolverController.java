package cn.cuiper.controller.fileupload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/multipartResolverController")
public class MultipartResolverController {

    /*
    * 配置文件解析器方式上传
    * 需要在springmvc.xml文件中配置文件解析器
    * <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    *   <property name="maxUploadSize" value="10485760" />
    * </bean>
    * */

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request, @RequestParam("file1")MultipartFile file1) throws Exception{
        // 本例path为target目录下，重启后文件可能会清空。部署到tomcat/webapps目录则不会。
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        String originalFilename = file1.getOriginalFilename();

        System.out.println("源文件名称:" + originalFilename);
        System.out.println("文件的接收参数的名称:" + file1.getName());
        System.out.println("文件的类型:" + file1.getContentType());
        System.out.println("文件的大小:" + file1.getSize());

        String newFileName = UUID.randomUUID().toString().replace("-", "")
                + "_" + originalFilename;
        file1.transferTo(new File(file, newFileName));
        return "success";
    }
}
