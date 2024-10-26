package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Information;
import cn.jia.domain.User;
import cn.jia.dto.ResumeDto;
import cn.jia.service.ResumeService;
import cn.jia.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Created by matou on 2019/11/24.
 */
@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    private String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16)+"/static/upload";

    @GetMapping
    public String resume(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)) {
            return "login";
        }
        User user = userService.findByUsername(username);
        ServerResponse serverResponse = resumeService.show(user.getId());
        if(serverResponse != null){
            model.addAttribute("resume", (ResumeDto) serverResponse.getData());
        }

        return "www/resume";
    }

    /*------------------------管理员----------------------------*/
    @RequiresRoles("system")
    @GetMapping("/manager")
    public String resume(Model model,
                         @RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex,
                         @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

        ServerResponse serverResponse = resumeService.showAll(pageIndex, pageSize);
        model.addAttribute("resume", serverResponse.getData());
        return "manage/jianli";
    }

    //判断是在线投递还是附件邮递
    @RequiresRoles("system")
    @GetMapping("/manager/look")
    @ResponseBody
    public ServerResponse look(@RequestParam(value = "userId") int userId,
                               @RequestParam(value = "pName")String pName) {
        //查询判断是投递的是在线简历还是附件简历
        return resumeService.judge(userId,pName);
    }

    @RequiresRoles("system")
    @GetMapping("/manager/show")
    public String show(Model model, @RequestParam(value = "userId") int userId) {
        ServerResponse serverResponse = resumeService.show(userId);
        model.addAttribute("resume", (ResumeDto) serverResponse.getData());
        return "manage/resume";
    }
    @RequiresRoles("system")
    @GetMapping("/manager/page")
    @ResponseBody
    public ServerResponse page(@RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex,
                               @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {
        ServerResponse serverResponse = resumeService.showAll(pageIndex, pageSize);
        return serverResponse;
    }

    //查询简历
    @RequiresRoles("system")
    @PostMapping("/manager/queryResume")
    @ResponseBody
    public ServerResponse query(@RequestParam String position,
                                @RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex,
                                @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize){
       return resumeService.query(position,pageIndex,pageSize);
    }

    //删除简历
    @RequiresRoles("system")
    @DeleteMapping("/manager/delete/{id}")
    @ResponseBody
    public ServerResponse delete(@PathVariable int id){
        return resumeService.delete(id);
    }
}
