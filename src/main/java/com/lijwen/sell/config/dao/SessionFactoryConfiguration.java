package com.lijwen.sell.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@ConfigurationProperties
public class SessionFactoryConfiguration {
    // mybatis-config.xml配置文件路径
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    // mybatis mapper的文件路径
    @Value("${mybatis_path}")
    private String mapperPath;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    // 实体类所在的package
    @Value("${entity_package}")
    private String entityPackage;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean
    createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactory.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactory;
    }
}
