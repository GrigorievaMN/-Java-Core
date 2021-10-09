package ru.geekbrains.courses.java_core;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class MainHomework8 {
    private static final String SEPARATORS = "[ .,!?;:]";
    public static void main(String[] args) {

      createdNewFile("C:\\geekbrains_hw8","file_1.txt", "A good beginning makes a good ending \nNo sweet without sweat \nExtremes meet" );
      createdNewFile("C:\\geekbrains_hw8","file_2.txt","An apple a day keeps the doctor away\nBetter late than never" );
      createdNewFile("C:\\geekbrains_hw8","file_3.txt","An apple a day keeps the doctor away\nBetter late than never" );
      createdNewFile("C:\\geekbrains_hw8","file_4.txt","No sweet without sweat \nBetter late than never\nExtremes meet" );
      linkFile ("C:\\geekbrains_hw8\\file_1.txt","C:\\geekbrains_hw8\\file_2.txt");

      System.out.println(findWord ("C:\\geekbrains_hw8\\file_2.txt", "sweat"));
      findWordDir ("C:\\geekbrains_hw8", "without");


    }

    public static void findWordDir (String nameDir, String findWord ){
        File file = new File (nameDir);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for( File f: files ){
                if (f.isFile()) {
                    if(findWord (nameDir +  '\\' + f.getName(), findWord)){
                        System.out.println(f.getName());

                    }
                }
            }

        }


    }


    public static boolean  findWord (String nameFile, String findWord){
        File file = new File (nameFile);
        if (!file.exists() ){
            System.out.println("Файла не существует");
            return false;
        }

        try (FileReader reader = new FileReader (file)) {
            char[] buf = new char[200];
            String  str = new String(buf, 0, reader.read(buf));
            String[] wordsFile = str.split(SEPARATORS);

            for (String word : wordsFile) {
                if (word.equalsIgnoreCase(findWord)) {
                    return true;
               }
            }

            } catch (IOException e) {
            e.printStackTrace();
        }


            return false;
        }


    public static void linkFile (String fileCopy, String fileWrite ) {
        File fileC = new File (fileCopy);
        File fileW = new File (fileWrite);
        if (!fileC.exists() ){
            System.out.println("Файла с данными не существует");
            return;
        }
        if (!fileW.exists() ){
            System.out.println("Файла для записи не существует");
            return;
        }
        try (FileReader reader = new FileReader (fileCopy)) {
            char[] buf = new char[100];
            String str = new String(buf,0,reader.read(buf));
            reader.close();

            FileWriter writer = new FileWriter(fileWrite, true);
            writer.append ("\n");
            writer.append (str);
            writer.flush();
            System.out.printf("Файл %s скопирован в %s.\n", fileC.getName(), fileW.getName());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void createdNewFile (String nameDir, String nameFile, String textFile ){

        File file = new File (nameDir);
        if (!file.exists()) {
            System.out.println("Директория не существует");
            if (file.mkdirs()) {
                System.out.println("Директория успешно создана");
            } else {
                System.out.println("Не удалось создать директорию");
                return;
            }
        }

        try {
            FileWriter writer = new FileWriter(nameDir + '\\' + nameFile, false);
            writer.write (textFile);
            writer.flush();
            System.out.printf("Файл %s записан.\n", nameFile);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
