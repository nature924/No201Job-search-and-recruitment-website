package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Skill;
import cn.jia.domain.User;
import cn.jia.service.SkillService;
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
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;
    @Autowired
    private UserService userService;

    @PostMapping("/addOrUpdate")
    @ResponseBody
    public ServerResponse addOrUpdate(Skill skill, HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return skillService.addOrUpdate(skill,user.getId());
    }


    @GetMapping
    @ResponseBody
    public ServerResponse get(HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return skillService.findByUserId(user.getId());
    }

}
