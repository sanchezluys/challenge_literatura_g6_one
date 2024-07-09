package dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
        Integer id,
        @JsonAlias("title") String Titulo,
        @JsonAlias("languages") String Idiomas,
        @JsonAlias("download_count") Integer Descargas,
        @JsonAlias("authors") List<String> Autores
    )
{

}
