package com.alura.literatura.literatura.challenge;
import model.LibroRepository;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	//@Autowired
	//private LibroRepository libroRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// llamar al menu
		Menu menu= new Menu();
		//
		menu.encabezado();
		menu.opciones();
	}
}