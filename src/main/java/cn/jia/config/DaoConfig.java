package cn.jia.config;


import com.github.pagehelper.Dialect;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by matou on 2019/2/28.
 * 数据库和事务管理的配置
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true) //启动事务管理器
@MapperScan(basePackages = "cn.jia.mapper",sqlSessionFactoryRef = "sqlSessionFactory")
public class DaoConfig {
    @Autowired
    private DataSource dataSource;
    @Bean
    public static PropertySourcesPlaceholderConfigurer
                          propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        Resource resource = new ClassPathResource("mappers/mybatisConfig.xml");
        sessionFactoryBean.setConfigLocation(resource);
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", Dialect.mysql.toString());
        pageHelper.setProperties(properties);
        Interceptor[] plugins =  new Interceptor[]{pageHelper};
        sessionFactoryBean.setPlugins(plugins);
        return  sessionFactoryBean;
    }
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        dataSourceTransactionManager.setRollbackOnCommitFailure(true);
        return dataSourceTransactionManager;
    }
}
