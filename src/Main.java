import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String pattern = "(\\d+)";
//        Pattern ptrn = Pattern.compile(pattern);
//        Matcher matcher = ptrn.matcher(inputString);

        ArrayList<String> arrayList = new ArrayList<>() {{
            add("Первое дело");
            add("Второе дело");
            add("Третье дело");
        }};
        String fail = "ВВедена неверная комманда.";
        String zapros = "ВВедите команду.";
        while (true) {
            System.out.println(zapros);
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            String[] comm = line.split(" ", 3);
            if (comm[0].equalsIgnoreCase("LIST")) {
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println(i + " - " + arrayList.get(i));
                }
            } else if (comm[0].equalsIgnoreCase("ADD")) {
                String pattern = "(\\d+)";
                Pattern ptrn = Pattern.compile(pattern);
                Matcher matcher = ptrn.matcher(comm[1]);
                if (matcher.find()) {
                    arrayList.add(Integer.parseInt(comm[1]), comm[2]);
                } else arrayList.add(comm[1] + " " + comm[2]);
            } else if (comm[0].equalsIgnoreCase("EDIT") && comm.length > 2
                    && (Integer.parseInt(comm[1]) <= comm.length)) {
                arrayList.set(Integer.parseInt(comm[1]), comm[2]);
            } else if (comm[0].equalsIgnoreCase("DELETE")) {
                arrayList.remove(Integer.parseInt(comm[1]));
            } else if (comm[0].equalsIgnoreCase("exit")) {
                System.out.println("Конец программы.");
                break;
            } else {
                System.out.println(fail);
                break;
            }
        }
    }
}
