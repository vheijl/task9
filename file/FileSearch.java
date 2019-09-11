package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileSearch {

    private String path;
    private String keyword;
    private int counter;

    public FileSearch(String path, String keyword) {
        this.path = path;
        this.keyword = keyword;
        search();
    }

    private void search() {
        try {

            File file = new File(this.path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // To make sure that I found only words and not parts of words, each line is
                // split on certain characters
                String[] words = line.split("[ ,.!?]");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].toLowerCase().equals(this.keyword.toLowerCase())) {
                        this.counter++;
                    }
                }
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File was not found!");
        } catch (IOException ex) {
            System.out.println("File IO Exception");
        }
    }

    public String getSearchResults() {
        return "\'" + this.keyword + "\'" + " was found on " + this.counter + " places in the file.";
    }
}