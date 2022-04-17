package model;

public final class Language {
    private Integer idLanguage;
    private static Integer newIdLanguage = 1;
    private String name;

    public Language(String name) {
        this.idLanguage = newIdLanguage;
        this.name = name;

        ++newIdLanguage;
    }

    public Language(Integer idLanguage, String name) {
        this.idLanguage = idLanguage;
        this.name = name;

        if (idLanguage >= newIdLanguage) {
            newIdLanguage = idLanguage + 1;
        }
    }

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public static Integer getNewIdLanguage() {
        return newIdLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "idLanguage=" + idLanguage +
                ", name='" + name + '\'' +
                '}';
    }
}
