package cn.jia.service;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Information;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by matou on 2019/11/25.
 */
public interface ResumeService {
    ServerResponse show(int userId);
    ServerResponse showAll(int pageIndex,int pageSize);
    ServerResponse judge(int userId,String pName);
    ServerResponse query(String positionName,int pageIndex,int pageSize);

    ServerResponse delete(Integer userId);

}
