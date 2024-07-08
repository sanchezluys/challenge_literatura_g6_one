package dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
        Integer id,
        @JsonAlias("Titulo") String title,
        @JsonAlias("Idiomas") String languages,
        @JsonAlias("Descargas") Integer download_count,
        @JsonAlias("Autores") List<String> authors
    )
{

}
