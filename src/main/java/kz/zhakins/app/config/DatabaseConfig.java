package kz.zhakins.app.config;


import  com.zaxxer.hikari.HikariDataSource;
import kz.zhakins.app.model.CategoryCredit;
import kz.zhakins.app.model.CategoryProduct;
import kz.zhakins.app.model.Customer;
import kz.zhakins.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by User on 11.06.2017.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    private ApplicationContext appContext;

    @Bean(name = "DataSource")
    public HikariDataSource dataSourceWinMacLinux() {
        return getDataSource("127.0.0.1","root","123456");
    }


    private   HikariDataSource getDataSource(String serverName, String user, String password){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        dataSource.addDataSourceProperty("databaseName","lombard");
        dataSource.addDataSourceProperty("portNumber","3306");
        dataSource.addDataSourceProperty("serverName","localhost");
        dataSource.addDataSourceProperty("user","root");
        dataSource.addDataSourceProperty("password","password");
        dataSource.addDataSourceProperty("characterEncoding","utf8");
        dataSource.addDataSourceProperty("useUnicode","true");
        //dataSource.addDataSourceProperty("password","");
        return  dataSource;
    }
    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;

    }

    @Bean
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource((DataSource) appContext.getBean("DataSource"));
        localSessionFactoryBean.setAnnotatedClasses(
                Customer.class,
                CategoryProduct.class,
                CategoryCredit.class,
                Product.class
        );

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");
        //properties.put("hibernate.connection.useUnicode","true");
        //properties.put("hibernate.connection.characterEncoding","utf8");
        //properties.put("hibernate.connection.charSet","utf8");

        localSessionFactoryBean.setHibernateProperties(properties);
        return  localSessionFactoryBean;
    }

}
