package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.User;
import cn.jia.service.PositionService;
import cn.jia.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private PositionService positionService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String collect(@RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                          @RequestParam(value = "pageNum",defaultValue = "5",required = false)int pageNum,
                          HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return "login";
        }
        User user = userService.findByUsername(username);
        ServerResponse serverResponse = positionService.findAllApply(pageIndex,pageNum,user.getId(),null);
        PageInfo pageInfo = (PageInfo)serverResponse.getData();
        model.addAttribute("apply",pageInfo);
        return "www/apply";
    }


    @RequiresRoles("system")
    @GetMapping("/manager")
    public String show(Model model) {
        model.addAttribute("apply", positionService.findAllApply(1,5,null,null).getData());
        return "manage/apply";
    }

    @RequiresRoles("system")
    @GetMapping("/manager/findByPage")
    @ResponseBody
    public ServerResponse findByPage(
            @RequestParam(value = "condition", required = false) String condition,
            @RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

        return positionService.findAllApply(pageIndex,pageSize,null,condition);
    }

    @RequiresRoles("system")
    @PutMapping("/update/state/{applyId}")
    @ResponseBody
    public ServerResponse applyUpdate(@PathVariable int applyId,@RequestParam("state") Integer state, HttpSession session){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return positionService.updateApply(state,user.getId(),applyId);
    }
}
