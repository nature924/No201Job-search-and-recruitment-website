package cn.jia.realm;

import cn.jia.domain.Role;
import cn.jia.domain.User;
import cn.jia.service.UserService;
import cn.jia.service.serviceImpl.RoleServiceImpl;
import com.google.common.collect.Lists;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleServiceImpl roleService;

    public String getName(){
        return this.getClass().getName(); // 返回类名
    }
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.fromRealm(this.getName()).iterator().next();
        User user = userService.findByUsername(userName);
        // List<String> permisssionList = Lists.newArrayList();
        List<String> roleList = Lists.newArrayList();
        Role roles = roleService.getRoles(user.getRoleId());
        if (roles == null){
            return null;
        }
        if(roles.getRoleId()==2){
        	roleList.add(roles.getRoleName());
        	roleList.add("system");
        }else {
        	roleList.add(roles.getRoleName());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        return info;
    }

    /**
     * 验证
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = userService.findByUsername(username);
        System.out.println(user);
        return new SimpleAuthenticationInfo(username,user.getPassword(),getName());
    }
}
