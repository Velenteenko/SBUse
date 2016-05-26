package com.ua.ingk.spboot.initial.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.ua.ingk.spboot.initial.Application;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Application.class)
public class JpaConfig implements TransactionManagementConfigurer {

	@Value("${db.briver}")
	private String driver;

	@Value("${db.url}")
	private String url;

	@Value("${db.user}")
	private String user;

	@Value("${db.password}")
	private String password;

	@Value("${db.hibernate.dialect}")
	private String dialect;

	@Value("${db.hibernate.hbm2ddl.auto}")
	private String hbm2dllAuto;

	@Bean
	public DataSource configureDtaSource() {

		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(password);

		return new HikariDataSource(config);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(configureDtaSource());
		entityManagerFactoryBean.setPackagesToScan("com.ua.ingk.spboot.initial");
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties jpaPproperties = new Properties();
		jpaPproperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
		jpaPproperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2dllAuto);

		entityManagerFactoryBean.setJpaProperties(jpaPproperties);

		return entityManagerFactoryBean;

	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new JpaTransactionManager();
	}

}
