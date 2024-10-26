package cn.jia.service.serviceImpl;

import cn.jia.domain.Role;
import cn.jia.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jia on 2018/1/30.
 */
@Service
public class RoleServiceImpl {
    @Autowired
    private RoleMapper roleMapper;

    public Role getRoles(int roleId){
        Role role = roleMapper.selectByPrimaryKey(roleId);
        return role ;
    }
}
