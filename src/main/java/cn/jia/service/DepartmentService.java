package cn.jia.service;

import cn.jia.dto.DepartmentDTO;
import com.github.pagehelper.PageInfo;

/**
 * @Auther: xyd
 * @Date: 2019/11/1 11:30
 * @Description:
 */
public interface DepartmentService {

    PageInfo<DepartmentDTO> selectBySearch(String search, Integer pageNum, Integer pageSize);
}
