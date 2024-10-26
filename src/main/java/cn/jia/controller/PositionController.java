package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Positions;
import cn.jia.domain.User;
import cn.jia.service.PositionService;
import cn.jia.service.UserService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by matou on 2019/11/29.
 * 社会招聘
 */
@Controller
@RequestMapping("/position")
public class PositionController {

    private static final int flag = 1;

    @Autowired
    private PositionService positionService;
    @Autowired
    private UserService userService;
    //展现页面
    @GetMapping
    public String show(Model model, HttpServletRequest request,
                       @RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                       @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        ServerResponse serverResponse = positionService.findAllBySocial(pageIndex,pageSize);
        PageInfo pageInfo =(PageInfo) serverResponse.getData();
        model.addAttribute("positions",pageInfo);
        return "www/position";
    }
    @GetMapping("/getDetail")
    public String getDetail(@RequestParam("pName")String pName,
                           Model model){
        ServerResponse serverResponse = positionService.getDeatils(pName,flag);
        model.addAttribute("detail",serverResponse.getData());
        serverResponse = positionService.findByRandom(flag);
        model.addAttribute("positions",serverResponse.getData());
        return "www/detail";
    }
    @GetMapping("/findByCondiction")
    @ResponseBody
    public ServerResponse findByCondiction(@RequestParam(value = "condition",required = false,defaultValue = "") String condition,
                                           @RequestParam(value = "keyWord",required = false,defaultValue = "")String keyWord,
                                           @RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                                           @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize,
                                           HttpServletRequest request) {
        List<String> pClassify = Lists.newArrayList();
        List<String> workSite = Lists.newArrayList();
        condition=condition.replaceAll("\\u00A0"," ");
         if (StringUtils.isNotEmpty(condition)){
             String[] arr = condition.trim().split(" ");
             for (int i = 0; i <arr.length ; i++) {
                 arr[i] = arr[i].trim();
                 if (StringUtils.isNotBlank(arr[i])){
                     if (arr[i].contains(".")){ //说明是分类
                         //去掉“.”
                         int index = arr[i].lastIndexOf(".");
                         String a = arr[i].substring(0,index);
                         pClassify.add(a.trim());
                     }else { //是地址
                       workSite.add(arr[i]);
                     }
                 }
             }
         }
        ServerResponse serverResponse = positionService.findByCondiction(pClassify,workSite,null,flag,keyWord,pageIndex,pageSize);
        return serverResponse;
    }

    //关键字搜索
   // @GetMapping("/findByKeyWord")
   // @ResponseBody
    public ServerResponse findByKeyWord(@RequestParam(value = "keyWord",required = false,defaultValue = "")String keyWord,
                                        @RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                                        @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        ServerResponse serverResponse = positionService.findByKeyWord(keyWord,pageIndex,pageSize,flag);
        return ServerResponse.buildSuccessData(serverResponse.getData());
    }

    //申请职位
    @PostMapping("/apply")
    @ResponseBody
    public ServerResponse apply(HttpSession session,int pId,int resumeId){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
       return positionService.apply(user.getId(),pId,resumeId);
    }

    //收藏职位
    @PostMapping("/collect")
    @ResponseBody
    public ServerResponse collect(HttpSession session,int pId){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return positionService.collect(user.getId(),pId,flag);
    }

    /*----------------------------职位管理-------------------------------------*/

    @RequiresRoles("system")
    @GetMapping("/manager")
    public String show(Model model){
        ServerResponse serverResponse = positionService.findAll(1,5);
        model.addAttribute("position",serverResponse.getData());
        return "manage/position";
    }

    @RequiresRoles("system")
    @GetMapping("/manager/findByPage")
    @ResponseBody
    public ServerResponse findByPage(@RequestParam(value = "condition",required = false)String condition,
                                     @RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                                     @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){

        if (StringUtils.isEmpty(condition)){
            condition = null;
        }
        //0代表无限制
        return positionService.findByKeyWord(condition,pageIndex,pageSize,0);

    }

    //管理员的权限
    @RequiresRoles("system")
    @PostMapping("/admin/add")
    @ResponseBody
    public ServerResponse add(Positions positions,HttpSession session){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        return positionService.insert(positions);
    }

    @GetMapping("/admin/getById/{id}")
    @ResponseBody
    @RequiresRoles("system")
    public ServerResponse findById(@PathVariable int id,HttpSession session){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        return positionService.findById(id);
    }
    //更新
    @PostMapping("/admin/update")
    @ResponseBody
    @RequiresRoles("system")
    public ServerResponse update(Positions positions,HttpSession session){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        return positionService.update(positions);
    }
    //删除
    @RequiresRoles("system")
    @DeleteMapping("/admin/delete/{id}")
    @ResponseBody
    public ServerResponse delete(@PathVariable int id,HttpSession session){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        return positionService.deleteById(id);
    }

    @GetMapping("/user/apply/findByPage")
    @ResponseBody
    public ServerResponse findByPageOne(
            @RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,HttpSession session) {
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return positionService.findAllApply(pageIndex,pageSize,user.getId(),null);
    }
}
