import java.io.*;
import java.util.Scanner;

public class examples {

    public void ExampleInit(String[] args){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.print("Введите целое число: ");
// возвращает истинну если с потока ввода можно считать целое число
        if(sc.hasNextInt()) {
/*Аналогично метод hasNextDouble(), применённый объекту класса Scanner, проверяет,
можно ли считать с потока ввода вещественное число типа double, а метод nextDouble() —
считывает его.*/
// считывает целое число с потока ввода и сохраняем в переменную
            i = sc.nextInt();
            System.out.println(i*2);
        } else {
            System.out.println("См. выше ^^^");
        }
/*Метод nextLine(), позволяющий считывать целую последовательность символов, т.е.
строку. Далее создаётся два таких объекта, потом в них поочерёдно записывается ввод
пользователя, на экран выводится одна строка, полученная объединением введённых
последовательностей символов.
*/
        Scanner sc2 = new Scanner(System.in);
        String s1, s2;
        s1 = sc2.nextLine();
        s2 = sc2.nextLine();
        System.out.println(s1 + s2);


        //Создание файла и запись в него ----------------------------------------
        String filename = "log.txt";
        File f = new File(filename);
        try{
            if(!f.exists()) f.createNewFile();
            try (PrintWriter pw = new PrintWriter(f.getAbsoluteFile())) {
                pw.println("2 ~!");
                pw.println("4 ~!");
                pw.println("6 ~!");
                pw.println("8 ~!");
            }
        }
        catch(IOException e){ throw new RuntimeException();}
        StringBuilder sb = new StringBuilder();
        if(f.exists()){
            try{
                try (BufferedReader br = new BufferedReader(new FileReader(f.getAbsoluteFile()))) {
                    String s;
                    while ((s = br.readLine()) != null) {//построчное чтение
                        sb.append(s);
                        sb.append("\n");
                    }
                }
            }catch(IOException e){throw new RuntimeException();}
        }
        System.out.print(sb.toString());//в sb.toString() хранится текст файла
    /*Для обновления файла можно сперва прочитать файл в переменную типа String,
    как это сделано в секции чтение из файла,
    а затем, сложив его с новым содержимым, записать в файл*/
        //Удаление файла --------------------------------------------------------
        //f.delete();
    }
}
