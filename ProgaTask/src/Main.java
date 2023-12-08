import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Детский сад. Вести учет детей в детском саду.
 * Ребенок: ФИО, пол, возраст
 * Группа: Название, номер
 * Добавлять/удалять группу и детей в них
 * Редактировать группы/детей
 * Выводить информацию по группам (группа, детей в них)
 **/

public class Main {

    public static String input() { //Чтобы поменьше вводы писать
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static Child convert(String s) { //Преобразует строку с информацией о ребенке в класс Child
        Child c = new Child();
        String[] t = s.split(" ");
        c.setName(t[0]+" "+t[1]+" "+t[2]);
        c.setGender(t[3]);
        c.setAge(Integer.parseInt(t[4]));
        return c;
    }
    public static ArrayList<Group> loadGroups() throws IOException { //Загружает в программу информацию из файлов в папке src/data
        ArrayList<Group> groups = new ArrayList<>();
        File folder = new File("src/data");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                Group gr = new Group();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                int j = 0;
                while ((line = reader.readLine()) != null) {
                    if (j == 0) {
                        gr.setNumber(Integer.parseInt(line));
                    } else if (j == 1) {
                        gr.setName(line);
                    } else if (j > 1) {
                        gr.addChild(convert(line));
                    }
                    j += 1;
                }
                groups.add(gr);
                gr.printGroup();
            }
        }
        return groups;
    }
    public static void writeGroups(ArrayList<Group> groups) { //Записывает всю информацию в файлы в папке src/data
    }
    public static void cmd_add(String cmd, ArrayList<Group> groups) { //Команда "Добавить"
        switch (cmd) {
            case  ("group"):
                Group g = new Group();
                g.setNumber(0);
                for(int i=1; i<100; i++) {
                    for(int j=0; j< groups.size(); j++) {
                        if(groups.get(j).getNumber()==i) {
                            break;
                        }
                        if(j==groups.size()-1) {
                            g.setNumber(i);
                            break;
                        }
                    }
                    if(g.getNumber()!=0) {
                        break;
                    }
                }
                System.out.println("Введите название новой группы:");
                String name = input();
                g.setName(name);
                groups.add(g);
                break;
            case ("child"):
                System.out.println("Добавить ребенка");
                Child c = new Child();
                System.out.println("Введите ФИО:");
                c.setName(input());
                System.out.println("Введите пол:");
                c.setGender(input());
                System.out.println("Введите возраст:");
                c.setAge(Integer.parseInt(input()));
                System.out.println("В какую группу добавить ребенка:");
                name = input();
                for (Group group : groups) {
                    if (group.getName().equals(name)) {
                        group.addChild(c);
                    }
                }
                break;
            default:
                break;
        }
    }
    public static void cmd_edit(String cmd, ArrayList<Group> groups) { //Команда "Редактировать"
    }
    public static void cmd_remove(String cmd, ArrayList<Group> groups) { //Команда "Удалить"
    }
    public static void cmd_print(String cmd, ArrayList<Group> groups) { //Команда "Распечатать"
        for (Group group : groups) {
            if(group.getName().equals(cmd)) {
                group.printGroup();
            }
        }
    }
    public static void cmd_print_all(ArrayList<Group> groups) {
        for (Group group : groups) {
            group.printGroup();
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Group> groups = loadGroups();

        String cmd = "";
        System.out.println("Команды:");
        System.out.println("add - добавить");
        System.out.println("edit - редактировать");
        System.out.println("remove - удалить");
        System.out.println("print - распечатать информацию о группе");
        System.out.println("print_all - распечатать информацию о всех группах");
        System.out.println("exit - записать данные и выйти");

        while(!cmd.equals("exit")) {
            System.out.println("");
            cmd = input();

            switch (cmd) {
                case  ("add"):
                    System.out.println("Добавить (group - группу, child - ребенка):");
                    cmd_add(input(), groups);
                    break;
                case  ("edit"):
                    System.out.println("Редактировать (group - группу, child - ребенка):");
                    cmd_edit(input(), groups);
                    break;
                case  ("remove"):
                    System.out.println("Удалить (group - группу, child - ребенка):");
                    cmd_remove(input(), groups);
                    break;
                case  ("print"):
                    System.out.println("Введите название группы: ");
                    cmd_print(input(), groups);
                    break;
                case  ("print_all"):
                    cmd_print_all(groups);
                    break;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
            writeGroups(groups);
        }
    }
}
