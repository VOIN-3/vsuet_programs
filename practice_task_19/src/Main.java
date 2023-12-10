import java.util.*;
import java.io.*;

/**19.Поиск по файлам. Реализовать программу осуществляющую поиск
 * по тексту файлов в определенном каталоге/подкаталогах. **/

public class Main {

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static File find_file(String rootDir,String fileName) {
        File target = null;
        File dir = new File(rootDir);
        File[] dirlist  = dir.listFiles();
        for (File file : dirlist) {
            if (file.isDirectory()) {
                target = find_file(file.getPath(), fileName);
                if (target != null) break;
            } else if (file.getName().contains(fileName)) {
                return file;
            }
        }
        return target;
    }
    public static void main(String[] args) {
        System.out.println("Поиск в папке:");
        String s1 = input();
        System.out.println("Ищем файл:");
        String s2 = input();

        File f = find_file(s1,s2);
        if(f != null) {
                System.out.println(f.getPath());
        } else {
            System.out.println("Файл не найден");
        }
    }
}