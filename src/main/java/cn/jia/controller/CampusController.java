package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Campus;
import cn.jia.domain.User;
import cn.jia.service.CampusService;
import cn.jia.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by matou on 2020/01/11.
 */
@Controller
@RequestMapping("/campus")
public class CampusController {

   @Autowired
    private CampusService campusService;
   @Autowired
    private UserService userService;



    @PostMapping("/addOrUpdate")
    @ResponseBody
    public ServerResponse addOrUpdate(Campus campus, HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return campusService.addOrUpdate(campus,user.getId());
    }


    @GetMapping
    @ResponseBody
    public ServerResponse get(HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return campusService.findByUserId(user.getId());
    }
}
