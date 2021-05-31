import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashSet;
import java.io.LineNumberReader;




public class LineCalculator {
    private Path dirPath;
    private HashSet<String> extensions;
    private int lineSum = 0;
    private int numberOfCheckedFiles = 0;

    public int getNumberOfCheckedFiles() {
        return numberOfCheckedFiles;
    }


    public Path getDirPath() {
        return dirPath;
    }

    public void setDirPath(Path dirPath) {
        this.dirPath = dirPath;
    }

    public HashSet<String> getExtensions() {
        return extensions;
    }

    // set whole collection
    public void setExtensions(HashSet<String> extensions) {
        this.extensions = extensions;
    }

    // add new extension to collection
    public void addExtension(String extension) {
        extensions.add(extension);
    }

    public int getLineSum() {
        return lineSum;
    }

    private String getExtension (File file) {
        String fname = file.getName();
        if (fname.lastIndexOf(".") == -1) {
            return "";  // without extension
        }

        return fname.substring(fname.lastIndexOf("."));

    }

    private int countLines(File file) throws IOException {

        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(file));
            while ((reader.readLine()) != null);
            return reader.getLineNumber();
        } catch (Exception ex) {
            return -1;
        } finally {
            if(reader != null)
                reader.close();
        }
    }

    public void countLinesInFiles() throws IOException {

        File dir = new File(String.valueOf(dirPath));
        File[] dirListing = dir.listFiles();

        if (dirListing != null) {
            for (File f : dirListing) {
                if (extensions.contains(getExtension(f).substring(1))) { // sprawdza czy są pliki z takim rozszerzeniami
                    System.out.println(f);
                    numberOfCheckedFiles += 1;
                    lineSum += countLines(f);
                }
            }
        }
    }

    public LineCalculator(String dirPath, HashSet<String> exts)  {
        try {
            Path directoryPath = Paths.get(dirPath);
            this.dirPath = directoryPath.toRealPath();
            System.out.println(this.dirPath);
        }
         catch (IOException e) {
            System.out.println("Can't find directory");
         }

        extensions = exts;

    }


    public static void main(String[] args) {

        // adding extensions names to Set
        if (args.length < 2) {
            throw new IllegalArgumentException("Pass at least one argument with extension!");
        }

        HashSet<String> ext_set = new HashSet<>();
        for (int i = 1; i < args.length; i++) {
            ext_set.add(args[i]);
        }

        LineCalculator l = new LineCalculator(args[0], ext_set);

        try {
            l.countLinesInFiles();
        }
        catch (IOException e) {
            System.out.println(e);
        }
//        l.addExtension("cmd");
//        l.addExtension("json");

        System.out.println("Number of checked files: " + l.getNumberOfCheckedFiles());
        System.out.println("Sum of lines: " + l.getLineSum());

    }
}
