package com.alevel;

import com.alevel.persistence.repository.user.AdminRepository;
import com.alevel.persistence.repository.user.PersonalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class })
public class Nix9FinalProjectApplication {

    private final BCryptPasswordEncoder encoder;
    private final AdminRepository adminRepository;
    private final PersonalRepository personalRepository;

    public Nix9FinalProjectApplication(BCryptPasswordEncoder encoder, AdminRepository adminRepository, PersonalRepository personalRepository) {
        this.encoder = encoder;
        this.adminRepository = adminRepository;
        this.personalRepository = personalRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Nix9FinalProjectApplication.class, args);
    }




}
