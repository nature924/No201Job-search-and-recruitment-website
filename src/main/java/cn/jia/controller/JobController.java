package cn.jia.controller;

import java.util.Date;

import cn.jia.common.ServerResponse;
import cn.jia.service.JobService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cn.jia.common.BusiRespCode;
import cn.jia.dto.JobDTO;
import cn.jia.mapper.JobMapper;

import javax.servlet.http.HttpSession;

/**
 * Created by matou on 2020/01/30.
 * 管理员控制器
 */
@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobMapper jobMapper;

    @Autowired
	private JobService jobService;

 	@RequiresRoles("system")
 	@PostMapping("/add")
	@ResponseBody
 	public ServerResponse add(JobDTO dto) {
 		try {
 			dto.setCreateTime(new Date());
 			jobMapper.insertSelective(dto);
 		} catch (Exception e) {
 			return ServerResponse.buildErrorMsg("添加失败");
 		}

 		return ServerResponse.buildSuccessMsg("添加成功");
 	}

 	@RequiresRoles("system")
 	@DeleteMapping("/delete/{id}")
	@ResponseBody
 	public ServerResponse delete(@PathVariable("id") Integer id) {
 		try {
 			jobMapper.deleteByPrimaryKey(id);
 		} catch (Exception e) {
			return ServerResponse.buildErrorMsg("删除失败");
 		}

		return ServerResponse.buildSuccessMsg("删除成功");
 	}

 	@RequiresRoles("system")
 	@PostMapping("/update")
	@ResponseBody
 	public ServerResponse update(JobDTO dto) {
 		try {
 			jobMapper.updateByPrimaryKeySelective(dto);
 		} catch (Exception e) {
			return ServerResponse.buildErrorMsg("修改失败");
		}

		return ServerResponse.buildSuccessMsg("修改成功");
 	}



	@GetMapping("/getById/{id}")
	@ResponseBody
	@RequiresRoles("system")
	public ServerResponse findById(@PathVariable("id") String id, HttpSession session){
		String username =(String) session.getAttribute("username");
		if (StringUtils.isEmpty(username)){
			return ServerResponse.buildErrorMsg("请登录");
		}
		return ServerResponse.buildSuccessData(jobMapper.selectByPrimaryKey(id));
	}

	@RequiresRoles("system")
	@GetMapping("/manager")
	public String show(Model model) {
		model.addAttribute("job", jobService.selectBySearch("", 1, 5));
		return "manage/job";
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
		return ServerResponse.buildSuccessData(jobService.selectBySearch(condition, pageIndex, pageSize));

	}
}
