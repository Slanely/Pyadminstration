package com;


import com.GlobalClasses.FilePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
public class MySpringBootConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(new UserConfig())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/in")
                .excludePathPatterns("/welcome");*/

    }


    @Autowired
    private FilePath filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("Resources Path : " + filePath.getResPath());
        FilePath.resourcesPath = filePath.getResPath();
        String privateResPath = "file:" + FilePath.getPrivateResPath();
        registry.addResourceHandler(FilePath.privateResURI + "**")
                .addResourceLocations(privateResPath);
        System.out.println("Users private resources path : " + privateResPath);
        super.addResourceHandlers(registry);
        String publicResPath = "file:" + FilePath.getPublicResPath();
        registry.addResourceHandler(FilePath.publicResURI + "**")
                .addResourceLocations(publicResPath);
        System.out.println("Public resources path : " + publicResPath);
        super.addResourceHandlers(registry);
    }
}
