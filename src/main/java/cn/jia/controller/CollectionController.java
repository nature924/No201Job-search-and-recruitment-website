package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.domain.User;
import cn.jia.service.CollectionService;
import cn.jia.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by matou on 2020/01/5.
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String collect(@RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                          @RequestParam(value = "pageNum",defaultValue = "5",required = false)int pageNum,
                          HttpSession session,Model model){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return "login";
        }
        User user = userService.findByUsername(username);
        ServerResponse serverResponse = collectionService.show(user.getId(),pageIndex,pageNum);
        PageInfo pageInfo = (PageInfo)serverResponse.getData();
        model.addAttribute("collection",pageInfo);
        return "www/collection";
    }

    @GetMapping("/findByPage")
    @ResponseBody
    public ServerResponse collect(@RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                          @RequestParam(value = "pageNum",defaultValue = "5",required = false)int pageNum,
                          HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        User user = userService.findByUsername(username);
        ServerResponse serverResponse = collectionService.show(user.getId(),pageIndex,pageNum);
      /*  PageInfo pageInfo = (PageInfo)serverResponse.getData();
        model.addAttribute("collection",pageInfo);*/
        return serverResponse;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ServerResponse delete(int id,HttpSession session){
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        return collectionService.cancelCollection(id);
    }
}
