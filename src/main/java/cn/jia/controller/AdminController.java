package cn.jia.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by matou on 2020/01/30.
 * 管理员控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequiresRoles("system")
    @GetMapping("/")
    public String index(HttpSession session) {
        return "manage/index";
    }

    //展现简历
    @RequiresRoles("system")
    @GetMapping("/resume")
    public String resume() {
        return "redirect:/resume/manager";
    }

    //展现题库
    @RequiresRoles("system")
    @GetMapping("/question")
    public String question() {
        return "redirect:/question/manager";
    }

    @RequiresRoles("system")
    @GetMapping("/position")
    public String position() {
        return "redirect:/position/manager";
    }

    @RequiresRoles("system")
    @GetMapping("/user")
    public String user() {
        return "redirect:/user/admin/show";
    }

    @RequiresRoles("system")
    @GetMapping("/department")
    public String department(){
        return "redirect:/department/manager";
    }

    @RequiresRoles("system")
    @GetMapping("/job")
    public String job(){
        return "redirect:/job/manager";
    }
    @RequiresRoles("system")
    @GetMapping("/questionType")
    public String questType(){
        return "redirect:/questType/manager";
    }

    @RequiresRoles("system")
    @GetMapping("/apply")
    public String apply(){
        return "redirect:/apply/manager";
    }
}
