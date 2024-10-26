package cn.jia.controller;

import cn.jia.common.ServerResponse;
import cn.jia.dto.DepartmentDTO;
import cn.jia.mapper.DepartmentMapper;
import cn.jia.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by matou on 2020/01/30. 管理员控制器
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
    private DepartmentService departmentService;

	// 展现简历
	@RequiresRoles("system")
	@PostMapping("/add")
    @ResponseBody
	public ServerResponse add(DepartmentDTO dto) {
		try {
			dto.setCreateTime(new Date());
			departmentMapper.insertSelective(dto);
		} catch (Exception e) {
			return ServerResponse.buildErrorMsg("添加公司失败！");
		}
		return ServerResponse.buildSuccessMsg("添加公司成功！");
	}

	// 展现题库
	@RequiresRoles("system")
	@DeleteMapping("/delete/{id}")
    @ResponseBody
	public ServerResponse delete(@PathVariable("id") String id,HttpSession session) {
		String username =(String) session.getAttribute("username");
		if (StringUtils.isEmpty(username)){
			return ServerResponse.buildErrorMsg("请登录");
		}
		try {
			departmentMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return ServerResponse.buildErrorMsg("删除失败！");
		}
		return ServerResponse.buildSuccessMsg("删除成功！");
	}

	@RequiresRoles("system")
    @ResponseBody
	@PostMapping("/update")
	public ServerResponse update(DepartmentDTO dto) {
		try {
			departmentMapper.updateByPrimaryKeySelective(dto);
		}catch (Exception e) {
			return ServerResponse.buildErrorMsg("修改失败！");
		}
		return ServerResponse.buildSuccessMsg("修改成功！");
	}

    @GetMapping("/getById/{id}")
    @ResponseBody
    @RequiresRoles("system")
    public ServerResponse findById(@PathVariable String id, HttpSession session){
        String username =(String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)){
            return ServerResponse.buildErrorMsg("请登录");
        }
        return ServerResponse.buildSuccessData(departmentMapper.selectByPrimaryKey(id));
    }

    @RequiresRoles("system")
    @GetMapping("/manager")
    public String show(Model model) {
        model.addAttribute("department", departmentService.selectBySearch("", 1, 5));
        return "manage/department";
    }


    @GetMapping("/manager/findByPage")
    @ResponseBody
    public ServerResponse findByPage(@RequestParam(value = "condition", required = false) String condition,
                                     @RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex,
                                     @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

        if (StringUtils.isEmpty(condition)) {
            condition = null;
        }
        //0代表无限制
        return ServerResponse.buildSuccessData(departmentService.selectBySearch(condition, pageIndex, pageSize));

    }

}
