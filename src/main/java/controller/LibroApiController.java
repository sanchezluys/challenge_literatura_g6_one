package controller;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dto.LibroDTO;
import model.Autor;
import model.AutorRepository;
import model.Libro;
import model.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LibroApiController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;
    public String llamarAPI(String path, String titulo) throws IOException {

        String url_str = "http://gutendex.com/"+path+titulo.replace(" ","%20");
        //System.out.println("api: "+url_str);
        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        // Accessing object
        String req_result = jsonobj.get("title").getAsString();
        //System.out.println("resultado= "+req_result);
        return (req_result);

    }
    // buscar por nombre del libro
    public void buscarPorNombre(String nombreLibro) throws IOException {
        System.out.println("⌛ Buscando....");
        String url_str = "http://gutendex.com/books/?search="+nombreLibro.replace(" ","%20");
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        //
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        // Accessing object
        Integer cuenta = Integer.valueOf(jsonobj.get("count").getAsString());
        // ⌛🕰️⏱️☎️🕯️
        if(cuenta > 0){
            System.out.println("\uD83D\uDE03 Se encotraron "+cuenta+" titulos que contienen "+ nombreLibro);
            //System.out.println(jsonobj);
            // Obtener el array de libros
            JsonArray librosArray = jsonobj.getAsJsonArray("results");
            // Crear la lista de LibroDTO
            List<LibroDTO> listaLibros = new ArrayList<>();
            // Mapear cada libro a un DTO
            for (JsonElement libroElement : librosArray) {
                JsonObject libroObject = libroElement.getAsJsonObject();
                //
                Integer id = libroObject.get("id").getAsInt();
                String title = libroObject.get("title").getAsString();
                String languages = libroObject.get("languages").getAsString();
                Integer download_count = libroObject.get("download_count").getAsInt();
                List<String> authors = new ArrayList<>();
                JsonArray authorsArray = libroObject.getAsJsonArray("authors");
                for (JsonElement authorElement : authorsArray) {
                    authors.add(authorElement.getAsJsonObject().get("name").getAsString());
                }

                LibroDTO libroDTO = new LibroDTO(id, title, languages, download_count, authors);
                listaLibros.add(libroDTO);
            }

            // Imprimir la lista de libros en forma de tabla
            imprimirTablaLibros(listaLibros);
            //
            System.out.println("\uD83D\uDCBE Guardando Libros/Autores en la Base de Datos...");
            guardarLibrosAutoresBD(listaLibros);

        }
        else{
            System.out.println("\uD83D\uDE41 lo sentimos, no se encontró ningún libro llamado: "+ nombreLibro);
        }


    }

    private void imprimirTablaLibros(List<LibroDTO> listaLibros) {
        // Definir el ancho de las columnas
        int anchoColumnaId = 8;
        int anchoColumnaTitulo = 60;
        int anchoColumnaAutores = 50;
        int anchoColumnaDescargas = 10;
        int anchoColumnaIdiomas=20;

        // Imprimir la cabecera de la tabla
        System.out.printf("%-" + anchoColumnaId + "s %-"+ anchoColumnaTitulo + "s %-"+ anchoColumnaIdiomas+ "s %-"+  anchoColumnaDescargas+ "s %-" + anchoColumnaAutores + "s%n", "ID", "Título", "Idiomas", "Descargas","Autores");
        System.out.println("-".repeat(anchoColumnaId + anchoColumnaTitulo + anchoColumnaIdiomas + anchoColumnaDescargas + anchoColumnaAutores));

        // Imprimir cada libro en una fila de la tabla
        for (LibroDTO libro : listaLibros) {
            System.out.printf("%-" + anchoColumnaId + "s %-"+ anchoColumnaTitulo + "s %-"+ anchoColumnaIdiomas +"s %-"+ anchoColumnaDescargas+ "s %-" +  anchoColumnaAutores + "s%n", libro.id(), libro.Titulo(), libro.Idiomas(), libro.Descargas(), String.join(", ", libro.Autores()));
        }
        System.out.println("-".repeat(anchoColumnaId + anchoColumnaTitulo + anchoColumnaIdiomas+ anchoColumnaDescargas +  anchoColumnaAutores));

    }


    // buscar por autor
    public void buscarPorAutor(String nombreAutor){

    }

    public void guardarLibrosAutoresBD(List<LibroDTO> librosDTO){
        for (LibroDTO libroDTO_inner : librosDTO) {
            Libro libro = new Libro();
            //libro.setId(libroDTO_inner.id());
            libro.setTitle(libroDTO_inner.Titulo());
            libro.setLanguages(libroDTO_inner.Idiomas());
            libro.setDownloadCount(libroDTO_inner.Descargas());

            Set<Autor> autores = new HashSet<>();
            for (String autorName : libroDTO_inner.Autores()) {
                Autor autor = new Autor();
                autor.setNombre(autorName);
                autores.add(autor);
            }
            libro.setAutores(autores);

            libroRepository.save(libro);
        }

        System.out.println("\uD83D\uDCBE Libros/Autores guardados en la Base de Datos!");
    }
}

