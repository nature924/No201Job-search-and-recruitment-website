package cn.jia.service;

import cn.jia.dto.QuestTypeDTO;
import com.github.pagehelper.PageInfo;

public interface QuestTypeService {
    PageInfo<QuestTypeDTO> selectBySearch(String search, Integer pageNum, Integer pageSize);
}
