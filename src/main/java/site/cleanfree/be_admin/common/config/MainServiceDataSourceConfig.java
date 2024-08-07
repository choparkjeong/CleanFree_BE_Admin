package site.cleanfree.be_admin.common.config;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "site.cleanfree.be_admin.membermanage.infrastructure",
    entityManagerFactoryRef = "mainServiceEntityManagerFactory",
    transactionManagerRef = "mainServiceTransactionManager"
)
public class MainServiceDataSourceConfig {

    @Bean(name = "mainServiceDataSource")
    @ConfigurationProperties(prefix = "spring.main-service.datasource")
    public javax.sql.DataSource mainServiceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mainServiceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mainServiceEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("mainServiceDataSource") DataSource mainServiceDataSource
    ) {
        return builder
            .dataSource(mainServiceDataSource)
            .packages("site.cleanfree.be_admin.membermanage.domain")
            .build();
    }

    @Bean(name = "mainServiceTransactionManager")
    public PlatformTransactionManager mainServiceTransactionManager(
        final @Qualifier("mainServiceEntityManagerFactory") EntityManagerFactory mainServiceEntityManagerFactory
    ) {
        return new JpaTransactionManager(mainServiceEntityManagerFactory);
    }
}
