package tk.iatsyk.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;


/**
 * User: Vova Iatsyk
 * Date: 18.10.2015
 */
@Configuration
public class DBConfiguration {

    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setHibernateProperties();

        return localSessionFactoryBean.getObject();
    }

    <bean id="sessionFactory"
    class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
    <property name="dataSource"ref="dataSource"/>
    <property name="mappingResources">
    <list>
    <value>com/studytrails/tutorials/springhibernatedaosupport/Person.hbm.xml</value>
    </list>
    </property>
    <property name="hibernateProperties">
    <props>
    <prop key="hibernate.dialect">org.hibernate.dialect.HSQLDialect</prop>
    <prop key="hibernate.current_session_context_class">thread</prop>
    </props>
    </property>

    </bean>

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.mysql.jdbcDriver");
        driverManagerDataSource.setUrl("jdbc:mysql:3030://cafe");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }
}
