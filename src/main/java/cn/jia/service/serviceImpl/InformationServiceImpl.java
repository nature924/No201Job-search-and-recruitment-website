package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Information;
import cn.jia.domain.Resume;
import cn.jia.dto.InformationDto;
import cn.jia.mapper.InformationMapper;
import cn.jia.mapper.ResumeMapper;
import cn.jia.service.InformationService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by matou on 2020/01/11.
 */
@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Autowired
    private ResumeMapper resumeMapper;

    @Value("${relativePath}")
    private String relativePath;

    @Transactional
  //  @CachePut(value = "information",key = "#userId")  //无论怎样都会放回到缓存中
    public ServerResponse addOrUpdate(Information information,Integer userId){
        information.setUserId(userId);
        Information information1 = informationMapper.selectByUserId(userId);
        if (information1 == null){
            //新增
            int i = informationMapper.insert(information);
            if (i < 1){
                return ServerResponse.buildErrorMsg("新增个人信息失败");
            }
            return ServerResponse.buildSuccessData(entityToDto(information));
        }
        //更新
        information.setUpdateTime(new Date());
        int i = informationMapper.updateByUserIdSelective(information);
        if (i < 1){
            return ServerResponse.buildErrorMsg("更新个人信息失败");
        }
//        List<Resume> resumes = resumeMapper.findByUserId(userId);
//        if (resumes == null || resumes.size() == 0){
//            Resume resume = new Resume();
//            resume.setUserId(userId);
//            resumeMapper.insert(resume);
//        }
        return ServerResponse.buildSuccessData(entityToDto(information));
    }

   // @Cacheable("userId")
    public ServerResponse findByUserId(Integer userId){
        if(userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        Information information = informationMapper.selectByUserId(userId);
        if (information == null){
            return null;
        }
        return ServerResponse.buildSuccessData(entityToDto(information));
    }

    @Transactional
    public ServerResponse upload(MultipartFile file, String path, int userId){
        if (file==null){
            return ServerResponse.buildErrorMsg("上传文件不能为空");
        }
        String appendName = null;
        String fileName = file.getOriginalFilename();
        int i = fileName.lastIndexOf(".");

        appendName  = fileName.substring(i); //得到后缀名
        fileName = getSystemTime() + appendName;
        File file1 = new File(path);
        if (!file1.exists()){
            file1.setWritable(true);
            file1.mkdirs();
        }
        File targetFile = new File(path,fileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.buildErrorMsg("上传文件失败");
        }
        Information information = informationMapper.selectByUserId(userId);
        //如果不存在实体，新建
        if (information == null){
            information = new Information();
            information.setUserId(userId);
            if (appendName.equals(".jpg") || appendName.equals(".png")){
                information.setPhoto(fileName);
                informationMapper.insert(information);
            }else {
                if (!appendName.equals(".pdf")){
                    return ServerResponse.buildErrorMsg("文件格式不正确,只支持PDF");
                }
                information.setFiles(fileName);
                informationMapper.insert(information);
            }
        }
        //如果存在则更新，把原来的文件删除
        else{
            if (appendName.equals(".jpg") || appendName.equals(".png")){
                String photo = information.getPhoto();
                if (StringUtils.isEmpty(photo)){
                    information.setPhoto(fileName);
                    informationMapper.updateByUserIdSelective(information);
                }else{
                    targetFile = new File(path,photo);
                    targetFile.delete(); //把原来的文件删除
                    information.setPhoto(fileName);
                    informationMapper.updateByUserIdSelective(information);
                }

            }else {
                if (!appendName.equals(".pdf")){
                    return ServerResponse.buildErrorMsg("文件格式不正确,只支持PDF");
                }
                String files = information.getFiles();
                if (StringUtils.isEmpty(files)){
                    information.setFiles(fileName);
                    informationMapper.updateByUserIdSelective(information);
                }else{
                    targetFile = new File(path,files);
                    targetFile.delete();
                    information.setFiles(fileName);
                    informationMapper.updateByUserIdSelective(information);
                }
            }
        }
        path = relativePath + fileName; //完整的文件路劲
        return ServerResponse.buildSuccessMsg(path);
    }

    //删除附件文件
    public ServerResponse deleteFile(Integer userId,String path){
        if (userId == null || StringUtils.isEmpty(path)){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        Information information = informationMapper.selectByUserId(userId);
        if (information !=  null){
            String fileName = information.getFiles();
            if (StringUtils.isEmpty(fileName)){
                return ServerResponse.buildErrorMsg("不存在附件简历");
            }
            information.setFiles("");
            int i = informationMapper.updateByPrimaryKey(information);
            if (i < 1){
                return ServerResponse.buildErrorMsg("删除失败");
            }
            File file = new File(path,fileName);
            file.delete();
            return ServerResponse.buildSuccessMsg("删除成功");
        }
        return ServerResponse.buildErrorMsg("删除失败");
    }

    private synchronized String getSystemTime(){
        return String.valueOf(System.currentTimeMillis()) + new Random().nextInt(100);
    }

    public InformationDto entityToDto(Information information){
        InformationDto informationDto = new InformationDto();
        informationDto.setUserId(information.getUserId());
        informationDto.setName(information.getName());
        informationDto.setPoliStatus(information.getPoliStatus());
        informationDto.setSex(information.getSex());
        informationDto.setPhone(information.getPhone());
        informationDto.setEmail(information.getEmail());
        informationDto.setJobIntension(information.getJobIntension());
        informationDto.setFiles(information.getFiles());
        informationDto.setDescribes(information.getDescribes());
        informationDto.setPhoto(relativePath+information.getPhoto());
        return informationDto;
    }

    /*---------------------------管理员方法---------------------------------*/
    public ServerResponse findAll() {
        List<Information> informationList = informationMapper.findAll();
        List<InformationDto> informationDtoList = Lists.newArrayList();
        if (informationList!=null || informationList.size()>0){
            for (Information information:informationList){
                InformationDto informationDto = entityToDto(information);
                informationDtoList.add(informationDto);
            }
        }
        return ServerResponse.buildSuccessData(informationDtoList);
    }
}
