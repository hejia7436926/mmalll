package com.mmall.controller.backend;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.pojo.User;
import com.mmall.service.IFileService;
import com.mmall.service.IProductService;
import com.mmall.service.IUserService;
import com.mmall.util.PropertiesUtil;
import com.mmall.vo.ProductDetailVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @version : 1.0
 * @ClassName: ProductManagerController
 * @Description :
 * @auther: hejia
 * @date: 2018/10/29
 */
@Controller
@RequestMapping("/manager/product")
public class ProductManagerController {
    @Autowired
    private IFileService fileService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IUserService userService;
    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if(userService.checkAdminRole(user).isSuccess()){
            //增加或者修改的逻辑
            return productService.saveOrUpdateProduct(product);
        }
        return ServerResponse.createByErrorMessage("不是管理员，无权操作");
    }

    @RequestMapping("set_sale_status.do")
    @ResponseBody
    public ServerResponse setSaleStatus(Integer productId,Integer status,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if(userService.checkAdminRole(user).isSuccess()){
            //校验是否是管理员
            return productService.setSaleStatus(productId,status);
        }
        return ServerResponse.createByErrorMessage("不是管理员，无权操作");
    }
    /**获取产品详情*/
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse detail(Integer productId,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if(userService.checkAdminRole(user).isSuccess()){
            //校验是否是管理员
            return productService.managerProductDetail(productId);
        }
        return ServerResponse.createByErrorMessage("不是管理员，无权操作");
    }

    /**展示产品*/
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse getProductList(HttpSession session,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if(userService.checkAdminRole(user).isSuccess()){
            //校验是否是管理员
            return productService.getProductList(pageNum,pageSize);
        }
        return ServerResponse.createByErrorMessage("不是管理员，无权操作");
    }

    /**搜索产品*/
    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse productSearch(HttpSession session,String productName,Integer productId, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if(userService.checkAdminRole(user).isSuccess()){
            //校验是否是管理员
            return productService.searchProduct(productName,productId,pageNum,pageSize);
        }
        return ServerResponse.createByErrorMessage("不是管理员，无权操作");
    }

    /**上传图片*/
    @RequestMapping("upload.do")
    @ResponseBody
    public ServerResponse upload(HttpSession session, @RequestParam(value = "upload_file",required = false)MultipartFile file, HttpServletRequest request){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if(userService.checkAdminRole(user).isSuccess()){
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetName = fileService.upload(file,path);
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetName;

            Map fileMap = Maps.newHashMap();
            fileMap.put("uri",targetName);
            fileMap.put("url",url);
            return ServerResponse.createBySuccess(fileMap);
            //校验是否是管理员
        }
        return ServerResponse.createByErrorMessage("不是管理员，无权操作");
    }

    /**上传富文本*/
    @RequestMapping("richtext_img_upload.do")
    @ResponseBody
    public Map richtextImgUpload(HttpSession session, @RequestParam(value = "upload_file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map resultMap = Maps.newHashMap();
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            resultMap.put("success",false);
            resultMap.put("msg","请登录管理员");
            return resultMap;
        }
        //富文本对于返回值有自己的要求，我们使用的是simditor所以按照sundutir的要求进行返回
//        {
//            "success":true/false,
//            "msg": "error message",# optional
//             "file_path": "{real file path}"
//        }
        if(userService.checkAdminRole(user).isSuccess()){
            //校验是否是管理员
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetName = fileService.upload(file,path);
            if(StringUtils.isBlank(targetName)){
                resultMap.put("success",false);
                resultMap.put("mag","上传失败");
                return resultMap;
            }
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetName;
            resultMap.put("success",true);
            resultMap.put("msg","上传成功");
            resultMap.put("file_path",url);
            response.addHeader("Access-Control-Allow-Headers","X-File-Name");
            return resultMap;
        }else{
            resultMap.put("msg","无权限操作");
            resultMap.put("success",false);
            return resultMap;
        }

    }
}
