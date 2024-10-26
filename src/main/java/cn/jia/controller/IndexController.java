package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.exception.ErrorException;
import cn.jia.service.PositionService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by matou on 2020/01/7.
 */
@Controller
@RequestMapping("/index1")
public class IndexController {

    @Autowired
    private PositionService positionService;
    //社会招聘
    @GetMapping("/findBySocialOrSchool")
    public String getSocial(@RequestParam(value = "keyWord") String keyWord,
                            @RequestParam(value = "flag") Integer flag,
                            @RequestParam(value = "pageIndex",defaultValue = "1",required = false)int pageIndex,
                            @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize,
                            Model model) throws ErrorException {
        if (StringUtils.isBlank(keyWord) || flag == null){
            throw new ErrorException("参数不能为空");
        }
        ServerResponse serverResponse = findByKeyWord(flag,keyWord,pageIndex,pageSize);
        PageInfo pageInfo = (PageInfo)serverResponse.getData();
        model.addAttribute("positions",pageInfo);
        if (flag == 1){
            return "www/position";
        }
        return "www/school";
    }

    private ServerResponse findByKeyWord(int flag,String keyWord,int pageIndex,int pageSize){
        return positionService.findByKeyWord(keyWord,pageIndex,pageSize,flag);
    }
}
