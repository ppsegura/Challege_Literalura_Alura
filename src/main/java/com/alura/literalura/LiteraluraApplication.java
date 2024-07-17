package com.alura.literalura;

import com.alura.literalura.principal.Principal;
import com.alura.literalura.repository.IAutorRepository;
import com.alura.literalura.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.alura.Literalura.repository")
@ComponentScan(basePackages = {"com.alura.Literalura"})
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private ILibroRepository ILibroRepository;

    @Autowired
    private IAutorRepository IAutorRepository;

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(ILibroRepository, IAutorRepository);
        principal.muestraElMenu();
    }
}