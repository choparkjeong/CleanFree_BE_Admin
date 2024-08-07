package site.cleanfree.be_admin.common.config;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "site.cleanfree.be_admin.auth.infrastructure",
    entityManagerFactoryRef = "adminServiceEntityManagerFactory",
    transactionManagerRef = "adminServiceTransactionManager"
)
public class AdminServiceDataSourceConfig {

    @Primary
    @Bean(name = "adminServiceDataSource")
    @ConfigurationProperties(prefix = "spring.admin-service.datasource")
    public javax.sql.DataSource adminServiceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "adminServiceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean adminServiceEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("adminServiceDataSource") DataSource adminServiceDataSource
    ) {
        return builder
            .dataSource(adminServiceDataSource)
            .packages("site.cleanfree.be_admin.auth.domain")
            .build();
    }

    @Primary
    @Bean(name = "adminServiceTransactionManager")
    public PlatformTransactionManager adminServiceTransactionManager(
        final @Qualifier("adminServiceEntityManagerFactory") EntityManagerFactory adminServiceEntityManagerFactory
    ) {
        return new JpaTransactionManager(adminServiceEntityManagerFactory);
    }

}
