package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.User;
import cn.jia.service.UserService;
import org.apache.catalina.Server;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jia on 2018/1/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*-------------------管理员------------------------*/
    @RequiresRoles("system")
    @GetMapping("/admin/show")
    public String show(Model model){
        ServerResponse serverResponse = userService.queryUserByName(null,1,8);
        model.addAttribute("user",serverResponse.getData());
        return "manage/user";
    }

    @RequiresRoles("system")
    @PostMapping("/admin/add")
    @ResponseBody
    public ServerResponse addUser(User user){
        return userService.addUser(user);
    }

    @RequiresRoles("system")
    @PostMapping("/admin/query")
    @ResponseBody
    public ServerResponse query(String name,
                                @RequestParam(value = "pageIndex",defaultValue = "1",required = false)int  pageIndex,
                                @RequestParam(value = "pageSize",defaultValue = "8",required = false)int pageSize){
        return userService.queryUserByName(name,pageIndex,pageSize);
    }

    @RequiresRoles("system")
    @PostMapping("/admin/changeRole")
    @ResponseBody
    public ServerResponse changeRole(String name,int roleId){
        return userService.changeRole(name,roleId);
    }

    @RequiresRoles("system")
    @DeleteMapping("/admin/delete/{id}")
    @ResponseBody
    public ServerResponse deleteByName(@PathVariable int id){
        return userService.deleteUserById(id);
    }
}
