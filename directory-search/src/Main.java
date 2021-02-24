import java.io.File;
import java.util.*;

public class Main {
    private static final String ROOT_PATH = "C:\\Users\\Orion\\IdeaProjects\\ojt-minis\\directory-search\\root";

    public static void main(String[] args) {
        File root = new File(ROOT_PATH);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file you'd like to search:");
        String searchParam = scanner.next();

        System.out.println("Here are the files you requested:");
        search2(root, searchParam);
    }

    // Basic implementation
    public static void search1(File dir, String searchParam){
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.getName().toLowerCase().contains(searchParam.toLowerCase())) {
                    System.out.println(f.getName());
                }
                if (f.isDirectory()) {
                    search1(f, searchParam);
                }
            }
        }
    }

    // Uses streams, but is less efficient than search1
    public static void search2(File dir, String searchParam){
        File[] files = dir.listFiles();
        assert files != null;
        for(File file : files){
            if(file.isDirectory()) search2(file,searchParam);
        }
        Arrays.stream(files).map(File::getName).filter(name -> name.contains(searchParam)).forEach(System.out::println);
    }
}
