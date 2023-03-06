/*
Вариант 12: 000100101;
путь к файлу Журнала: 1 - из файла;
реализация событий: 0 - явная реализация события

  000100101: 1 - Обращение к потоку вывода на консоль;
         <-  3 - Равенство указанного объекта некоторому значению;
             6 - Обращение к потоку вывода в указанный файл
*/


import MyEvents.Generators.Source;
import MyEvents.Handlers.ConsoleOutputReciever;
import MyEvents.Handlers.EqualToParticularValueReciever;
import MyEvents.Handlers.FileOutputReciever;
import MyEvents.LogWriter;


import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final Integer particularValue = 5;

    public static void main(String[] args) throws IOException {
        String path_to_log = null;
        var fr_log_src = new FileReader("C:\\Users\\Victor\\Desktop\\3course\\6сем\\Java\\lab3\\JabaLab3\\src\\log_path_source.txt");
        var scn = new Scanner(fr_log_src);
        path_to_log = scn.nextLine();
        System.out.println(path_to_log);
        LogWriter lw = new LogWriter(path_to_log);

        Source srcConsoleOutputSource = new Source(new ConsoleOutputReciever(lw));
        Source srcEqualValue = new Source(new EqualToParticularValueReciever(lw));
        Source srcFileOutputSource = new Source(new FileOutputReciever(lw));


        Scanner scanner = new Scanner(System.in);
        String usrInput;
        System.out.println("""
                Data input from file('1') or console('0'):\s
                Enter the choice:""");
        srcConsoleOutputSource.genEv();

        usrInput = scanner.nextLine();
        while (!usrInput.equals("1") & !usrInput.equals("0")) {
            System.out.println("Wrong unput!\nTry again: ");
            usrInput = scanner.nextLine();
            System.out.println("Your input: "+usrInput);
            srcConsoleOutputSource.genEv();
        }

        ArrayList<Integer> int_array = new ArrayList<Integer>();
        Scanner scf = null;
        FileReader fr = null;
        switch (usrInput) {
            case ("1") -> {
                File file_input = new File("C:\\Users\\Victor\\Desktop\\3course\\6сем\\Java\\lab3\\JabaLab3\\src\\input.txt");
                try {
                    fr = new FileReader(file_input.getAbsoluteFile());
                    scf = new Scanner(fr);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            case ("0") -> {
                scf = new Scanner(System.in);
                System.out.println("Enter the numbers with non-number chat at the end:");
                srcConsoleOutputSource.genEv();
            }
            default -> {
                System.out.println("Something bad happened");
                srcConsoleOutputSource.genEv();
            }
        }

        while (scf.hasNextInt()) {
            int new_elem = scf.nextInt();
            if (new_elem == particularValue) {
                srcEqualValue.genEv();
            }
            int_array.add(new_elem);
        }

        System.out.println("UNSORTED ARRAY:");
        System.out.println(int_array);
        lw.LogString("UNSORTED ARRAY:");
        lw.LogString(int_array.toString());
        srcFileOutputSource.genEv();

        int_array = MyIndividual.GetSortedArray(int_array);
        System.out.println("SORTED ARRAY:");
        System.out.println(int_array);

        lw.LogString("SORTED ARRAY:");
        lw.LogString(int_array.toString());
        srcFileOutputSource.genEv();


        if (fr != null) {
            fr.close();
        }
        lw.CloseFile();
    }
}
