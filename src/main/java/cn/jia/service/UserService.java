package cn.jia.service;

import cn.jia.common.ServerResponse;
import cn.jia.domain.User;

public interface UserService {
     User findByUsername(String username);
     ServerResponse register(User user);
     ServerResponse checkAnswer(String username,String answer1,String answer2);
     ServerResponse changePassword(String username,String newPassword);
     ServerResponse deleteUserById(Integer name);
     ServerResponse changeRole(String name,Integer roleId);
     ServerResponse queryUserByName(String name,int pageIndex,int pageSize);
     ServerResponse addUser(User user);
}
