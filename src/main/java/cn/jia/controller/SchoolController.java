package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.User;
import cn.jia.service.PositionService;
import cn.jia.service.UserService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by matou on 2020/01/4.
 */
@Controller
@RequestMapping("/school")
public class SchoolController {

    private static final int flag = 2;

    @Autowired
    private PositionService positionService;
    @Autowired
    private UserService userService;

    //-----------------------校园------------
    @GetMapping
    public String showSchool(Model model,HttpServletRequest request,
                             @RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                             @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        ServerResponse serverResponse = positionService.findBySchool(pageIndex,pageSize);
        PageInfo pageInfo =(PageInfo) serverResponse.getData();
        model.addAttribute("positions",pageInfo);
        return "www/school";
    }
    //关键字搜索
    //@GetMapping("/findByKeyWord")
    //@ResponseBody
    public ServerResponse findByKeyWord(@RequestParam(value = "keyWord")String keyWord,
                                        @RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                                        @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        ServerResponse serverResponse = positionService.findByKeyWord(keyWord,pageIndex,pageSize,flag);
        return ServerResponse.buildSuccessData(serverResponse.getData());
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
        List<String> desc = Lists.newArrayList();
        //(^\h*)|(\h*$)
        condition = condition.replaceAll("\\u00A0"," ");
       // condition=condition.replaceAll("\\u00A0"," ");
        if (StringUtils.isNotEmpty(condition)){
           parseCondition(condition,pClassify,workSite,desc);
        }
        ServerResponse serverResponse = positionService.findByCondiction(pClassify,workSite,desc,flag,keyWord,pageIndex,pageSize);
        PageInfo pageInfo =(PageInfo)serverResponse.getData();
     //   request.setAttribute("pages",pageInfo.getPages());
        return serverResponse;
    }

    //申请职位
    @PostMapping("/apply")
    @ResponseBody
    public ServerResponse apply(HttpSession session, int pId,int resumeId){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        return positionService.apply(user.getId(),pId,resumeId );
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

    private void parseCondition(String condition,List<String> pClassify ,
                                List<String> workSite, List<String> desc){
       // desc.add("不限");
        String[] arr = condition.trim().split(" ");
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = arr[i].trim();
            if (StringUtils.isNotBlank(arr[i])){
                if (arr[i].contains(".")){ //说明是分类
                    //去掉“.”
                    int index = arr[i].lastIndexOf(".");
                    String a = arr[i].substring(0,index);
                    pClassify.add(a.trim());
                }else if (arr[i].contains(";")){  //是类型
                    int index = arr[i].lastIndexOf(";");
                    String a = arr[i].substring(0,index);
                    desc.add(a);
                } else { //是地址
                    workSite.add(arr[i]);
                }
            }
        }
    }


}
