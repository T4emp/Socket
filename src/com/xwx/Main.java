package com.xwx;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        Client client = new Client();
        client.Conn("127.0.0.1", 6666);
        int num = 2;
        String i;
        System.out.println("1. Замена текста из консоли\n2. Замена из файла");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        switch(num){
            case 1:
                //Ввод текста через консоль
                System.out.println("Введите текст");
                Scanner scanner1 = new Scanner(System.in);
                i = client.Msg(scanner1.nextLine());
                System.out.println("Результат: " + i);
                break;
            case 2:
                //Выбор файла через стандартные средства Java
                System.out.println("Укажите файл");
                JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jFileChooser.setDialogTitle("Выберите текстовый файл");
                jFileChooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("TXT files", "txt");
                jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
                int returnValue = jFileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = jFileChooser.getSelectedFile();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    i = client.Msg(bufferedReader.readLine());
                    System.out.println("Результат: " + i);
                }
                break;
            default:
                System.out.println("Введена неккоректная цифра!");
        }
    }
}