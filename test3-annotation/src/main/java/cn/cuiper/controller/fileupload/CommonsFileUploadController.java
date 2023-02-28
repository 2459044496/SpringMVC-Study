package cn.cuiper.controller.fileupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("commonsFileUploadController")
public class CommonsFileUploadController {

    /*
    * 使用commons-fileupload文件上传
    * 需要先导入jar包
    * <dependency>
    *   <groupId>commons-fileupload</groupId>
    *   <artifactId>commons-fileupload</artifactId>
    *   <version>1.3.1</version>
    * </dependency>
    * */

    @RequestMapping("fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception{
        // 本例path为target目录下，重启后文件可能会清空。部署到tomcat/webapps目录则不会。
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> fileItems = upload.parseRequest(request);

        for (FileItem fileItem : fileItems) {
            // 判断fileItem是一个普通表单还是上传的文件
            if (fileItem.isFormField()) {

            } else {
                String fileName = fileItem.getName();// 文件名称
                String newFileName = UUID.randomUUID().toString().replace("-", "")
                        + "_" + fileName;
                fileItem.write(new File(path, newFileName));// 写入文件
                fileItem.delete();// 删除临时文件
            }
        }
        return "success";
    }
}
