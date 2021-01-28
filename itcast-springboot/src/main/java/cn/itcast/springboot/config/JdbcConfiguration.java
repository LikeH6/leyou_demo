package cn.itcast.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author chenjiahao
 * @date 2021/1/22 17:00
 */
@Configuration  // 声明一个类是一个java配置类。相当于一个xml配置文件
@EnableConfigurationProperties(JdbcProperties.class)  // 启用配置文件
public class JdbcConfiguration {


    @Autowired  // 使用注解是第一种方式，不用这个注解是第二种方式，则要使用下面的  JdbcConfiguration  方法
    private JdbcProperties jdbcProperties;

//    public JdbcConfiguration(JdbcProperties jdbcProperties){
//        this.jdbcProperties = jdbcProperties;
//    }

    // 第三种是直接将bean作为形参传入，上面的 参数 和 方法都不需要
//    @Bean  // 把方法的返回值注入到spring容器
//    public DataSource dataSource(JdbcProperties jdbcProperties){
//        DruidDataSource druidDataSource=new DruidDataSource();
//        druidDataSource.setDriverClassName(jdbcProperties.getDriver());
//        druidDataSource.setUrl(jdbcProperties.getUrl());
//        druidDataSource.setUsername(jdbcProperties.getUsername());
//        druidDataSource.setPassword(jdbcProperties.getPassword());
//        return druidDataSource;
//    }

    // 第四种：最方便，但是有局限性，一般使用第一种，上面的参数、方法以及下面的方法都不要，
    // 将JdbcProperties.java中的  ConfigurationProperties 注解放到方法上就行了，不必放到类上
//    @Bean  // 把方法的返回值注入到spring容器
//    @ConfigurationProperties(prefix = "jdbc")  // 使用前缀
//    public DataSource dataSource(){
//        DruidDataSource druidDataSource=new DruidDataSource();
//        return druidDataSource;
//    }

    @Bean  // 把方法的返回值注入到spring容器
    public DataSource dataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(this.jdbcProperties.getDriver());
        druidDataSource.setUrl(this.jdbcProperties.getUrl());
        druidDataSource.setUsername(this.jdbcProperties.getUsername());
        druidDataSource.setPassword(this.jdbcProperties.getPassword());
        return druidDataSource;
    }

}
