package cn.jia.service;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Work;
import cn.jia.dto.WorkDto;

/**
 * Created by matou on 2020/01/11.
 */
public interface WorkService {
    ServerResponse addOrUpdate(Work work, Integer userId);
    ServerResponse findByUserId(Integer userId);
    WorkDto entityToDto(Work work);
}
