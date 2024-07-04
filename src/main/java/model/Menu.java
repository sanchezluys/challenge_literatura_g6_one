package model;

import controller.LibroController;

import java.util.Scanner;

public class Menu {
    

    public void encabezado()
    {
        // emoticones: ⚠️🔥📝✅❎📂⚙️🏷️📦📆🗓️🕑🏁➡️⬆️🎁🛒🛍️✏️🖍️✂️🔒🔓💎😀😃
        //**
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║ ALURA LATAM                                              ║");
        System.out.println("║ CHALENGER LITERATURA                                     ║");
        System.out.println("║ Profesores: Bruno Fernández/ Genesys Rondon / Eric Fraga ║");
        System.out.println("║ Backend con JAVA 17                                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ Usando API de: http://gutendex.com/                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
    public void muestreDespedida()
    {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         DESPEDIDA                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Muchas gracias por usar esta Aplicacion de Literarura  ║");
        System.out.println("║ Nos vemos pronto!!                                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");;
    }

    public void opciones() {
        String opcion="0";
        Scanner scanner = new Scanner(System.in);
        //

        while(!opcion.equals("8"))
        {
            LibroController libros= new LibroController();
            this.muestreMenu();
            //
            opcion = scanner.nextLine();
            //
            switch (opcion)
            {
                case "1":
                    //System.out.println("Buscar libro por titulo.");
                    libros.buscarPorTitulo();
                    break;
                case "2":
                    //System.out.println("Listar libros registrados.");
                    libros.listarLibros();
                    break;
                case "3":
                    //System.out.println("Listar autores registrados.");
                    libros.listarAutores();
                    break;
                case "4":
                    //System.out.println("Listar autores vivos en determinado año.");
                    libros.listarAutoresVivosPorAno();
                    break;
                case "5":
                    //System.out.println("Listar libros por idioma.");
                    this.idiomas();
                    break;
                case "8":
                    muestreDespedida();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
        scanner.close();
    }

    private void idiomas() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                         IDIOMAS                          ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Es-Español                                            ║");
        System.out.println("║ 2. Fr-Frances                                            ║");
        System.out.println("║ 3. En-Ingles                                             ║");
        System.out.println("║ 4. xx-xx                                                 ║");
        System.out.println("║ 8. Volver sin listar                                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese su opción: ");
    }

    private void muestreMenu() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                         MENÚ                             ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Buscar libro por titulo                               ║");
        System.out.println("║ 2. Listar libros registrados                             ║");
        System.out.println("║ 3. Listar autores registrados                            ║");
        System.out.println("║ 4. Listar autores vivos en determinado año               ║");
        System.out.println("║ 5. Listar libros por idioma                              ║");
        System.out.println("║ 8. Salir                                                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese su opción: ");
    }
}

