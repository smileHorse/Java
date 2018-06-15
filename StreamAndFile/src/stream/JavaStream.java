package stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class JavaStream {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\");
        File[] listFiles = file.listFiles();
        for (File listFile : listFiles) {
            System.out.println(listFile.toString());
        }

        System.out.println("==========================");

        DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get("D:\\"));
        for (Path entrie : entries) {
            System.out.println(entrie.toString());
        }
    }
}
