package cn.jia.config;

import cn.jia.realm.AuthRealm;
import cn.jia.realm.CredentialMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login1");
        shiroFilterFactoryBean.setSuccessUrl("/index1");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error1");
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/static/**", "anon");
        map.put("/login/getVerify", "anon");
        map.put("/login1", "anon");
        map.put("/","anon");
        map.put("/loginCheck", "anon");
        map.put("/register", "anon");
        map.put("/registerCheck", "anon");
        map.put("/checkAnswer", "anon");
        map.put("/changePassword", "anon");
        map.put("/position/**", "anon");
        map.put("/school/**", "anon");
        map.put("/index1/**", "anon");
        map.put("/admin/**", "authc");
        map.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager(AuthRealm authRealm,CookieRememberMeManager cookieRememberMeManager) {
        DefaultSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(authRealm);
        defaultSecurityManager.setRememberMeManager(cookieRememberMeManager);
        return defaultSecurityManager;
    }

    @Bean(name = "authRealm")
    public AuthRealm authRealm(CredentialMatcher credentialMatcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCacheManager(new MemoryConstrainedCacheManager());
        authRealm.setCredentialsMatcher(credentialMatcher);
        return authRealm;
    }

    @Bean(name = "credentialsMatcher")
    public CredentialMatcher credentialsMatcher() {
        return new CredentialMatcher();
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor
    authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(securityManager);
        return sourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean(name =  "simpleCookie")
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setHttpOnly(true);
        simpleCookie.setName("helloWorld");
        simpleCookie.setMaxAge(2592000); //最多30天
        return simpleCookie;
    }

    @Bean(name = "cookieRememberMeManager")
    public CookieRememberMeManager cookieRememberMeManager(SimpleCookie simpleCookie){
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(simpleCookie);
        manager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return manager;
    }

    @Bean
    public FormAuthenticationFilter  formAuthenticationFilter(){
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        formAuthenticationFilter.setRememberMeParam("rememberMe");
        return  formAuthenticationFilter;
    }

}
