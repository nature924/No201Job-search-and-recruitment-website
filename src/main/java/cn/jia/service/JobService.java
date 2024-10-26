package cn.jia.service;

import cn.jia.dto.DepartmentDTO;
import cn.jia.dto.JobDTO;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: xyd
 * @Date: 2019/11/1 11:30
 * @Description:
 */
public interface JobService {

    PageInfo<JobDTO> selectBySearch(String search, Integer pageNum, Integer pageSize);
}
