package model;

import java.util.List;

public record LibroDTO(
        Integer id,
        String title,
        String languages,
        Integer download_count,
        List<String> authors)

{

}
