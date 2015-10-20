package tk.iatsyk.config;

import org.springframework.boot.context.embedded.*;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Collections;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {

    @Bean
    public ServletRegistrationBean dispatcherRegistration() {
        return new ServletRegistrationBean(dispatcherServlet(), "/");
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public FilterRegistrationBean charEncodingFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean(charEncFilter());
        filter.setUrlPatterns(Collections.singleton("/*"));
        return filter;
    }

    @Bean
    public CharacterEncodingFilter charEncFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setSessionTimeout(60);
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/notFound"));
        ((TomcatEmbeddedServletContainerFactory) container).addContextCustomizers((TomcatContextCustomizer) (context) -> {
            context.addWelcomeFile("home.jsp");
            context.setDisplayName("Coders Guild");
        });
    }

}

