package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Information;
import cn.jia.domain.User;
import cn.jia.mapper.InformationMapper;
import cn.jia.mapper.UserMapper;
import cn.jia.service.InformationService;
import cn.jia.service.UserService;
import cn.jia.util.RandomValidateCodeUtil;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * Created by matou on 2020/01/11.
 */
@Controller
@RequestMapping("/info")
public class InformationController {

    private static final Logger logger = LoggerFactory.getLogger(InformationController.class);

    @Autowired
    private InformationService informationService;
    @Autowired
    private UserService userService;
    private String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16)+"/src/main/webapp/static/upload";;


    /**
     * 新增或更新个人信息
     * @param information
     * @param httpSession
     * @return
     */
    @PostMapping("/addOrUpdate")
    @ResponseBody
    public ServerResponse addOrUpdateInfo(Information information, HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return informationService.addOrUpdate(information,user.getId());
    }

    /**
     * 查询个人信息
     * @param session
     * @return
     */
    @GetMapping
    @ResponseBody
    public ServerResponse get(HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return informationService.findByUserId(user.getId());
    }
    
    public static String decode(String s) {
        StringBuffer sbuf = new StringBuffer();
        int l = s.length();
        int ch = -1;
        int b, sumb = 0;
        for (int i = 0, more = -1; i < l; i++) {
            /* Get next byte b from URL segment s */
            switch (ch = s.charAt(i)) {
            case '%':
                ch = s.charAt(++i);
                int hb = (Character.isDigit((char) ch) ? ch - '0'
                        : 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
                ch = s.charAt(++i);
                int lb = (Character.isDigit((char) ch) ? ch - '0'
                        : 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
                b = (hb << 4) | lb;
                break;
            case '+':
                b = ' ';
                break;
            default:
                b = ch;
            }
            /* Decode byte b as UTF-8, sumb collects incomplete chars */
            if ((b & 0xc0) == 0x80) { // 10xxxxxx (continuation byte)  
                sumb = (sumb << 6) | (b & 0x3f); // Add 6 bits to sumb  
                if (--more == 0)
                    sbuf.append((char) sumb); // Add char to sbuf  
            } else if ((b & 0x80) == 0x00) { // 0xxxxxxx (yields 7 bits)  
                sbuf.append((char) b); // Store in sbuf  
            } else if ((b & 0xe0) == 0xc0) { // 110xxxxx (yields 5 bits)  
                sumb = b & 0x1f;
                more = 1; // Expect 1 more byte  
            } else if ((b & 0xf0) == 0xe0) { // 1110xxxx (yields 4 bits)  
                sumb = b & 0x0f;
                more = 2; // Expect 2 more bytes  
            } else if ((b & 0xf8) == 0xf0) { // 11110xxx (yields 3 bits)  
                sumb = b & 0x07;
                more = 3; // Expect 3 more bytes  
            } else if ((b & 0xfc) == 0xf8) { // 111110xx (yields 2 bits)  
                sumb = b & 0x03;
                more = 4; // Expect 4 more bytes  
            } else /*if ((b & 0xfe) == 0xfc)*/{ // 1111110x (yields 1 bit)  
                sumb = b & 0x01;
                more = 5; // Expect 5 more bytes  
            }
            /* We don't test if the UTF-8 encoding is well-formed */
        }
        return sbuf.toString();
    }
    /**
     * 上传文件
     * @param filename
     * @param session
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public ServerResponse uploadPhoto(@RequestParam("filename")MultipartFile filename, HttpSession session,String verifyInput){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("用户未登录");
        }
        //检验验证码
        String originalVerify = (String)session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
//        if(!StringUtils.equals(originalVerify,verifyInput)){
//            return ServerResponse.buildErrorMsg("验证码错误");
//        }
        User user = userService.findByUsername(username);
        path = decode(path);
        logger.error("path:{}",path);
        return informationService.upload(filename,path,user.getId());
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public ServerResponse uploadFiles(@RequestParam("filename")MultipartFile filename, HttpSession session){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("用户未登录");
        }
        User user = userService.findByUsername(username);
        return informationService.upload(filename,path,user.getId());
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ServerResponse deleteFile(HttpSession session){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("用户未登录");
        }
        User user = userService.findByUsername(username);
        return informationService.deleteFile(user.getId(),path);
    }

}
