package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Education;
import cn.jia.domain.User;
import cn.jia.service.EducationService;
import cn.jia.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

/**
 * Created by matou on 2020/01/11.
 */
@Controller
@RequestMapping("/edu")
public class EducationController {

    @Autowired
    private EducationService educationService;
    @Autowired
    private UserService userService;

    @PostMapping("/addOrUpdate")
    @ResponseBody
    public ServerResponse addOrUpdate(Education education, HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return educationService.addOrUpdate(education,user.getId());
    }


    @GetMapping
    @ResponseBody
    public ServerResponse get(HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return educationService.findByUserId(user.getId());
    }
}
