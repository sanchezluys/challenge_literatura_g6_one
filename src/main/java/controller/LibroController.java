package controller;

import java.io.IOException;
import java.util.Scanner;

public class LibroController {
    public void buscarPorTitulo() throws IOException {
        this.buscarPorTituloEncabezado();
        this.recibirTituloLibro();
    }

    private void recibirTituloLibro() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String titulo = scanner.nextLine();
        LibroApiController api = new LibroApiController();
        api.buscarPorNombre(titulo);

    }

    private void buscarPorTituloEncabezado() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           BUSCAR LIBRO POR TITULO                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese el nombre del libro a ser buscado, ejemplo:    ║");
        System.out.println("║ > don quijote de la mancha                             ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese el título para buscarlo: ");
    }

    public void listarLibros() {
        this.listarLibrosEncabezado();
    }

    private void listarLibrosEncabezado() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LISTAR LIBROS REGISTRADOS EN LA BD           ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Se listarán los libros que estan registrados en la BD  ║");
        System.out.println("║                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese el titulo: ");
    }

    public void listarAutores() {
        this.listarAutoresEncabezado();
    }

    private void listarAutoresEncabezado() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LISTAR AUTORES EN LA BD                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Se listarán los autores que esten registrados en la BD ║");
        System.out.println("║                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese el titulo: ");
    }

    public void listarAutoresVivosPorAno() {
        this.listarAutoresVivosPorAnoEncabezado();
    }

    private void listarAutoresVivosPorAnoEncabezado() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LISTA DE AUTORES VIVOS EN LA FECHA DEFINIDA  ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Se listarán los autores que estan registrados en la BD ║");
        System.out.println("║ y esten vivos en una fecha determinada                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese el año: ");
    }
}
