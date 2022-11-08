package com.gdu.notice.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@MapperScan(basePackages = {"com.gdu.notice.mapper"})

@PropertySource(value = {"classpath:mybatis/config/mybatis.properties"}) // resources 파일에 깔아둔 마이바티스 파일 경로  // DB 파일 경로 지정
// classpath가 있어야 디비 프러퍼티스를 불러올 수 있음.

@EnableTransactionManagement
@Configuration
public class DBConfig {

   
   // db.properties 파일을 읽어서 변수에 저장하기
   // ${프로퍼티명}
   
   @Value(value = "${hikari.driver}")  // db.properties의 프로퍼티 이름
   private String driver;
   
   @Value(value = "${hikari.url}")
   private String url;
   
   @Value(value = "${hikari.username}")
   private String username;
   
   @Value(value = "${hikari.password}")
   private String password;
   
   @Value(value = "${mapper.locations}")
   private String mapperLocations;
   
   @Value(value = "${config.location}")
   private String configLocation;

   
   // HikariConfig
   @Bean
   public HikariConfig config() {
      HikariConfig config =new HikariConfig();
      config.setDriverClassName(driver);
      config.setJdbcUrl(url);
      config.setUsername(username);
      config.setPassword(password);
      return config;
      
   }
   
   // HikariDataSource
   @Bean(destroyMethod = "close")
   public HikariDataSource dataSource() {
      return new HikariDataSource(config());
   }
   
   // SqlSessionFactory
      @Bean
      public SqlSessionFactory factory() throws Exception {
         SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
         bean.setDataSource(dataSource());
         bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations)); // 경로 입력한 것을 디비 프로퍼티스로 이동 후 @Value에서 가져옴
         bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLocation)); // 경로 입력한 것을 디비 프로퍼티스로 이동 후 @Value에서 가져옴
         return bean.getObject();
      }
      
   
   // SqlSessionTemplate
    @Bean
   public SqlSessionTemplate sqlSessionTemplate() throws Exception {
       return new SqlSessionTemplate(factory());
    }
   
   // 트랜잭션 처리를 위한 TransactionManager를 Bean으로 등록한다
   @Bean
   public TransactionManager transactionManamger() {
      return new DataSourceTransactionManager(dataSource());
   }
   
}

