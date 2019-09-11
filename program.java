import java.io.File;
import file.FileInfo;
import file.FileSearch;

public class program {
    public static void main(String[] args) {

        String filePath = args[0];
        String searchWord = args[1];

        if (args.length > 1) {
            FileInfo fi = new FileInfo(filePath);
            System.out.println(fi.getFileInfo());

            FileSearch fs = new FileSearch(filePath, searchWord);
            System.out.println(fs.getSearchResults());

        } else {
            System.out.println("You must provide the filename (small.txt) and search keyword as arguments");
        }
    }
}