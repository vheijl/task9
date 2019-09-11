package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInfo {

    private String filePath;
    private File file;

    public FileInfo(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    private String getName() {
        return this.file.getName();
    }

    private long getFileSize() {
        return this.file.length();
    }

    private long getNumberOfLines() {
        Path path = Paths.get(this.filePath);
        long lineCount = 0;
        try {
            lineCount = Files.lines(path).count();
        } catch (IOException ex) {
            System.out.println("File IO exception");
        }
        return lineCount;
    }

    public String getFileInfo() {
        String fileInfo = "";
        double fileLength = getFileSize() / 1024.0;
        // This is probably not a super accurate way to round/truncate the file size,
        // but good enough for this application
        fileLength = Math.floor(fileLength * 100) / 100;
        fileInfo += "File name: " + getName();
        fileInfo += "\nFile size: " + fileLength + "kB";
        fileInfo += "\nNumber of lines: " + getNumberOfLines();
        return fileInfo;
    }
}