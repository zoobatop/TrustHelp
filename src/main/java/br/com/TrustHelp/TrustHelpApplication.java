package br.com.TrustHelp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrustHelpApplication implements CommandLineRunner {

    @Autowired
    private Server server;

    public static void main(String[] args) {
        SpringApplication.run(TrustHelpApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Aplicação TrustHelp iniciada!");
        server.initializeServices();
    }
}
