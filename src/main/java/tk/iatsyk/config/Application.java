package tk.iatsyk.config;

import org.apache.catalina.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.*;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Collections;

@SpringBootApplication
@ComponentScan("tk.iatsyk")
public class Application implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

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

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setSessionTimeout(60);
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/notFound"));
        ((TomcatEmbeddedServletContainerFactory) container).addContextCustomizers(new TomcatContextCustomizer() {
            @Override
            public void customize(Context context) {
                context.addWelcomeFile("home.jsp");
                context.setDisplayName("Coders Guild");

            }
        });
    }

}
