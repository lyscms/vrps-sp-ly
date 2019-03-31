package com.ly.imp4m.foreign.controller;

import com.ly.imp4m.util.FileOperate;
import com.ly.imp4m.util.JSONUtil;
import com.ly.imp4m.util.SendMail;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 工具控制器类
 *
 * @author 10589
 * @date 2016/10/5
 * @time 10:42
 */
@Controller
public class Util implements ServletContextAware {
    private ServletContext servletContext;


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * 多文件文件上传处理（多个上传控件）
     * @param httpServletRequest
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload.html",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String upload(String childPath, HttpServletRequest httpServletRequest) throws IOException {
        /**
         * 文件上传处理
         */

        /**获取本地存储路径*/
        Properties pro = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("/ApplicationResources.properties");
        try {
            pro.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**创建一个通用的多部分解析器*/
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(httpServletRequest.getSession().getServletContext());

        //初始化返回List对象
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        /**判断 request 是否有文件上传,即多部分请求*/
        if(multipartResolver.isMultipart(httpServletRequest)){

            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)httpServletRequest;

            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();

            String desPath = File.separator+childPath;//相对于imgSavePath目录下的子目录，自定义(子目录必须存在)
            String path = this.servletContext.getRealPath(pro.getProperty("upload")+desPath);  //获取本地存储路径
            System.out.println("上传文件保存路径："+path);
            int count =1;
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();

                    //文件的大小
                    long length = file.getSize();
                    System.out.println("length值=" + length);
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        System.out.print("上传文件"+count+"："+myFileName+"  用时：");
                        //重命名上传后的文件名
                        String fileName = file.getOriginalFilename();

                        String fileType = fileName.substring(fileName.lastIndexOf("."));

                        String fileSuffix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
                        String fileNameSuffix = fileName.substring(0,fileName.lastIndexOf("."));
                        String newFileName = new Date().getTime() + fileType;
                        //定义上传路径
                        File file2 = new File(path,newFileName); //新建一个文件
                        file.transferTo(file2);
                        count++;

                        //设置返回数据
                        Map<String,String> map = new HashMap<String,String>();
                        map.put("fileSuffix",fileSuffix);
                        map.put("fileName",fileName);
                        map.put("name",fileNameSuffix);
                        map.put("filePath",pro.getProperty("upload").substring(1,pro.getProperty("upload").length())+childPath+"/"+newFileName);//文件路径
                        list.add(map);
                    }
                }


                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println((finaltime - pre)+"ms");
            }
        }
        return JSONUtil.toJSONString(list);
    }


    /**
     * 根据文件路径删除系统下的文件
     * @param picsPath
     * @return
     */
    @RequestMapping(value = "/delFile.html",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String deletePic(String picsPath) {
        JSONObject jsonObject = new JSONObject();
        if(FileOperate.delFile(this.servletContext.getRealPath("/"+picsPath))){
            jsonObject.put("code","1");
        }else{
            jsonObject.put("code","0");
        }
        return jsonObject.toString();
    }


    /**
     * 发送邮件提醒
     * @return
     */
    @RequestMapping(value = "/sendEmail.html",produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String sendEmail(String title, String content) {
        JSONObject jsonObject = new JSONObject();
        if(SendMail.sendalert(title,content)){
            jsonObject.put("code","1");
        }else{
            jsonObject.put("code","0");
        }
        return jsonObject.toString();
    }

}
