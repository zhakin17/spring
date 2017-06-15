package kz.zhakins.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by User on 11.06.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("kz.zhakins.app")
public class WebConfig extends WebMvcConfigurerAdapter{
    @Bean
    public InternalResourceViewResolver resolver(){
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/views/");
      resolver.setSuffix(".jsp");
      return  resolver;
    }
    /*
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }
*/
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }


}
