package model;

public enum Idiomas {
    ES("Español", "español", "spanish"),
    EN("Ingles", "ingles", "english"),
    FR("Frances", "frances");

    private final String nombre;
    private final String[] alias;

    Idiomas(String nombre, String... alias) {
        this.nombre = nombre;
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getAlias() {
        return alias;
    }

    public static Idiomas fromAlias(String alias) {
        for (Idiomas idioma : values()) {
            for (String a : idioma.alias) {
                if (a.equalsIgnoreCase(alias)) {
                    return idioma;
                }
            }
        }
        return null;
    }
}
