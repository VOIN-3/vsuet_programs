import java.io.*;
import java.util.*;

public class Main {

    public static String input() { //Чтобы поменьше вводы писать
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        return cmd;
    }

    public static void cmd_print() { //Вывод группы
        System.out.print("Название группы: ");
        String cmd = input();
    }

    public static void cmd_add() { //Добавление группы/ребенка
        String cmd = input();
        if(cmd == "group") {
            Group g = new Group();
            System.out.print("Номер группы: ");
            cmd = input();
            g.number = Integer.valueOf(cmd);
            System.out.print("Название группы: ");
            cmd = input();
            g.name = cmd;
        }
        if(cmd == "child") {
            Child c = new Child();
            System.out.print("ФИО ребенка: ");
            cmd = input();
            c.name = cmd;
            System.out.print("Пол ребенка: ");
            cmd = input();
            c.gender = cmd.toCharArray()[0];
            System.out.print("Возраст ребенка: ");
            cmd = input();
            c.age = Integer.valueOf(cmd);
            System.out.print("Добавить ребенка в группу: ");
            cmd = input();
        }
    }

    public static void cmd_edit() { //Изменение группы/ребенка
    }

    public static void cmd_remove() { //Удаление группы/ребенка
    }

    public static void main(String[] args) throws IOException {
        String cmd = "";
        /**
        while(!cmd.equals("exit")) {

            System.out.println("");
            cmd = input();

            switch (cmd) {
                case  ("print"):
                    cmd_print();
                    break;
                case ("add"):
                    cmd_add();
                    break;
                case ("edit"):
                    cmd_edit();
                    break;
                case ("remove"):
                    cmd_remove();
                    break;
                default:
                    break;
            }

        }
         **/
        File folder = new File("src/data");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }

    }
}
