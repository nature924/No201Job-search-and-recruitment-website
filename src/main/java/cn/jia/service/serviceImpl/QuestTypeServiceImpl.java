package cn.jia.service.serviceImpl;

import cn.jia.dto.DepartmentDTO;
import cn.jia.dto.QuestTypeDTO;
import cn.jia.mapper.DepartmentMapper;
import cn.jia.mapper.QuestTypeMapper;
import cn.jia.service.DepartmentService;
import cn.jia.service.QuestTypeService;
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
public class QuestTypeServiceImpl implements QuestTypeService {

    @Autowired
    private QuestTypeMapper questTypeMapper;

    @Override
    public PageInfo<QuestTypeDTO> selectBySearch(String search, Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Example example = new Example(QuestTypeDTO.class);
        if (StringUtils.isNotBlank(search)) {
            example.createCriteria().andLike("name", "%"+search.trim()+"%");
        }
        example.orderBy("createTime").desc();
        return new PageInfo<>(questTypeMapper.selectByExample(example));
    }
}
