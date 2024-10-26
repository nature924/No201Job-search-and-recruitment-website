package cn.jia.service.serviceImpl;

import cn.jia.dto.DepartmentDTO;
import cn.jia.mapper.DepartmentMapper;
import cn.jia.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Auther: xyd
 * @Date: 2019/11/1 11:30
 * @Description:
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public PageInfo<DepartmentDTO> selectBySearch(String search, Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Example example = new Example(DepartmentDTO.class);
        if (StringUtils.isNotBlank(search)) {
            example.createCriteria().andLike("name", "%"+search.trim()+"%");
        }
        example.orderBy("createTime").desc();
        return new PageInfo<>(departmentMapper.selectByExample(example));
    }
}
