package cn.jia.service.serviceImpl;

import cn.jia.common.RoleType;
import cn.jia.common.ServerResponse;
import cn.jia.domain.User;
import cn.jia.mapper.UserMapper;
import cn.jia.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;

    public User findByUsername(String username){
        return userMapper.finByUsername(username);
    }

    //注册
    @Transactional
    public ServerResponse register(User user){
        //默认是普通用户
        user.setRoleId(RoleType.user.getId());
        User user1 = userMapper.finByUsername(user.getUsername());
        if (user1 != null){
            return ServerResponse.buildErrorMsg("用户已存在");
        }
        int result = userMapper.insert(user);
        if (result < 1){
            return ServerResponse.buildErrorMsg("注册失败");
        }
        return ServerResponse.buildSuccessMsg("注册成功,可以登录了");
    }

    //检验答案
    public ServerResponse checkAnswer(String username,String answer1,String answer2){
        if (StringUtils.isEmpty(username)|| StringUtils.isEmpty(answer1)||StringUtils.isEmpty(answer2)){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        User user = userMapper.finByUsername(username);
        if (user == null){
            return ServerResponse.buildErrorMsg("用户不存在");
        }
        if ((!answer1.equals(user.getAnswer1()) )|| (!answer2.equals(user.getAnswer2()))){
            return ServerResponse.buildErrorMsg("答案错误");
        }
        return ServerResponse.buildSuccessMsg("验证成功");
    }
    //重置密码
    public ServerResponse changePassword(String username,String newPassword){
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(newPassword)){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        //根据用户名查找用户
        User user = userMapper.finByUsername(username);
        Md5Hash md5Hash = new Md5Hash(newPassword,"");
        user.setPassword(md5Hash.toString());
        int i = userMapper.updateByPrimaryKey(user);
        if (i<1){
            return ServerResponse.buildErrorMsg("更新失败");
        }
        return ServerResponse.buildSuccessMsg("更新成功");
    }


    public ServerResponse addUser(User user){
        User user1 = userMapper.finByUsername(user.getUsername());
        if (user1 != null && user1.getFlag() == 1){
            return ServerResponse.buildErrorMsg("用户已存在");
        }
        Md5Hash md5Hash = new Md5Hash(user.getPassword().toString(),"",1);
        user.setPassword(md5Hash.toString());
        int i = userMapper.insert(user);
        if (i < 1){
            return ServerResponse.buildErrorMsg("新增失败");
        }
        return ServerResponse.buildSuccessMsg("新增成功");
    }

    public ServerResponse queryUserByName(String name,int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<User> userList = userMapper.findUserLike(name); //如果为name=null，则查询全部
        PageInfo pageInfo = new PageInfo(userList);
        return ServerResponse.buildSuccessData(pageInfo);
    }
    public ServerResponse changeRole(String name,Integer roleId){
        if (StringUtils.isEmpty(name) || roleId == null ){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        User user = userMapper.finByUsername(name);
        if (user == null){
            return ServerResponse.buildErrorMsg("不存在此用户");
        }
        user.setRoleId(roleId);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i < 1){
            return ServerResponse.buildErrorMsg("更新角色失败");
        }
        return ServerResponse.buildSuccessMsg("更新角色成功");
    }
    public ServerResponse deleteUserById(Integer id){
        if (id == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null){
            return ServerResponse.buildErrorMsg("不存在此用户");
        }
      //  user.setFlag(0);
      //  int i = userMapper.updateByPrimaryKeySelective(user);
        int i = userMapper.deleteByPrimaryKey(id);
        if (i < 1){
            return ServerResponse.buildErrorMsg("删除失败");
        }
        return ServerResponse.buildSuccessMsg("删除成功");
    }
}
