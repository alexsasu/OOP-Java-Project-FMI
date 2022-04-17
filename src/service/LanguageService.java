package service;

import model.Language;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanguageService {
    private static LanguageService INSTANCE = null;
    private final ReadService readService = ReadService.getInstance();
    private final WriteService writeService = WriteService.getInstance();

    private final String fileName = "src/csvFiles/Languages.csv";
    private List<Language> languages = new ArrayList<>();

    private LanguageService() { }

    public static LanguageService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LanguageService();
        }

        return INSTANCE;
    }

    public Language getLanguageById(Integer idLanguage) {
        try {
            int currentPosition = 0, index = -1;
            for (Language language : languages) {
                if (language.getIdLanguage().equals(idLanguage)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return languages.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public Language getLanguageByName(String name) {
        try {
            int currentPosition = 0, index = -1;
            for (Language language : languages) {
                if (language.getName().equals(name)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return languages.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void addLanguage(Language language) {
        languages.add(language);
    }

//    public void updateLanguageById(Integer idLanguage) {
//
//    }

    public void deleteLanguageById(Integer idLanguage) {
        try {
            int currentPosition = 0, index = -1;
            for (Language language : languages) {
                if (language.getIdLanguage().equals(idLanguage)) {
                    index = currentPosition;
                }
                ++currentPosition;
            }
            languages.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readLanguagesFromFile() {
        String[] languages = readService.readFromFile(this.fileName).split("\n");

        try {
            for (String language : languages) {
                String[] languageInfo = language.split(",");
                Language languageToBeAdded = new Language(Integer.parseInt(languageInfo[0]), languageInfo[1]);
                this.languages.add(languageToBeAdded);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void writeLanguagesToFile() {
        // Deleting file contents
        try {
            new FileOutputStream(this.fileName).close();
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }

        for (Language language : languages) {
            String languageInfo = language.getIdLanguage() + "," + language.getName();

            writeService.writeToFile(fileName, languageInfo);
        }
    }
}
