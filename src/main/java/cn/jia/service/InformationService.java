package cn.jia.service;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Information;
import cn.jia.dto.InformationDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by matou on 2020/01/11.
 */
public interface InformationService {

     ServerResponse addOrUpdate(Information information, Integer userId);
     ServerResponse findByUserId(Integer userId);
     ServerResponse upload(MultipartFile file, String path, int userId);
     ServerResponse deleteFile(Integer userId,String path);
     ServerResponse findAll();
     InformationDto entityToDto(Information information);
}
