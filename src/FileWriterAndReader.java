import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriterAndReader {

//    public String path = "src/file.txt";
//    public File file = new File(path);


    public static void writeText(String toWrite, File file) {
        try (Writer fw = new FileWriter(file, true)) {
            if (file.length() == 0) {
                fw.write(toWrite);
            } else {
                toWrite = "\n" + toWrite;
                fw.write(toWrite);
            }
        } catch (IOException e) {
            System.out.println("Возникла какая-то ошибка IO");
        }
    }

    public static List<String> getFileToListString(File file) {
        try (Reader fr = new FileReader(file, StandardCharsets.UTF_8)) {
            List<String> result = new ArrayList<>();
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                result.add(br.readLine());
            }
            return result;
        } catch (IOException exception) {
            System.out.println("Ошибка IOException ----- выскочила ошибка IO");
            System.out.println(exception.toString());
            return null;
        }
    }

    public static void clearFile(File file) {
        try (Writer fw = new FileWriter(file)) {
            fw.write("");
        } catch (IOException e) {
            System.out.println("Выскочило исключение при очистке файла");
        }
    }
}









//    public void mainClass() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true){
//            System.out.println("Что вы хотите сделать?");
//            System.out.println("1 - write line, 2 - read file, 3 - clear file");
//            int choice = scanner.nextInt();
//            if (choice == 0) return;
//            if (choice == 1) {
//                System.out.println("Введите текст для записи в файл");
//                String text = scanner.next();
//                writeText(text, file);
//            } else if (choice == 2) {
//                System.out.println("Приступаем к чтению файла");
//                List<String> fileArray = getFileToListString(file);
//                try {
//                    for (String line : fileArray) {
//                        System.out.println(line);
//                    }
//                } catch (NullPointerException e) {
//                    System.out.println("Ошибка NullPointer ----- Пустой файл");
//                }
//
//            } else if (choice == 3) {
//                clearFile(file);
//                System.out.println("Файл очищен");
//            } else {
//                break;
//            }
//        }
//    }