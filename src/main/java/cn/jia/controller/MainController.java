package cn.jia.controller;


import cn.jia.common.ServerResponse;
import cn.jia.domain.User;
import cn.jia.service.UserService;
import cn.jia.util.RandomValidateCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login1")
    public String login(){

        return "login";
    }

    @GetMapping("/")
    public String index1(){
        return "index";
    }

    @GetMapping("/index1")
    public String index(){
        return "index";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(String username, String password, HttpSession session, Model model,String verifyInput){

        //检验验证码
        String originalVerify = (String)session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        if(!StringUtils.equals(originalVerify,verifyInput)){
            model.addAttribute("verifyCode","false");
            return "login";
        }

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        usernamePasswordToken.setRememberMe(true);

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(usernamePasswordToken);
            session.setAttribute("username",(String)subject.getPrincipal());
            model.addAttribute("username",(String)subject.getPrincipal());
            return "index";
        }catch (Exception e){
            model.addAttribute("flag","failed");
            return "login";
        }
    }
    @GetMapping("/error1")
    public String loginError(){
        return "err";
    }

      /**
       * 注册
       */
      @GetMapping("/register")
      public String register(){
          return "register";
      }



      @PostMapping("/registerCheck")
      @ResponseBody
      public ServerResponse register(User user){
          //密码加密
          Md5Hash md5Hash = new Md5Hash(user.getPassword().toString(),"",1);
          user.setPassword(md5Hash.toString());
          return userService.register(user);
      }
      //检验答案
      @PostMapping("/checkAnswer")
      @ResponseBody
      public ServerResponse checkAnswer(String username, String answer1,
                                        String answer2, HttpSession httpSession){
          ServerResponse serverResponse =   userService.checkAnswer(username,answer1,answer2);
          if (serverResponse.isSuccess()){
              //存储一个token，根据username
              httpSession.setAttribute(username, UUID.randomUUID());
          }

          return  serverResponse;
      }

      //更改密码
      @PostMapping("/changePassword")
      @ResponseBody
     public ServerResponse changePassword(String username,
                              String newPassword,HttpSession session){
          Object UUID = session.getAttribute(username);
          if (UUID == null){
              return ServerResponse.buildErrorMsg("请先验证密保");
          }
         return userService.changePassword(username,newPassword);
     }

     @GetMapping("/logout")
     public String logout(HttpSession session){
         session.removeAttribute("username");
         Subject subject = SecurityUtils.getSubject();
         subject.logout();
         return "login";
     }


    /**
     * 生成验证码
     */
    @GetMapping(value = "/login/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");
            //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            //输出验证码图片方法
            randomValidateCode.getRandcode(request, response);
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }


}
