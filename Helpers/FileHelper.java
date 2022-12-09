package Helpers;

import Database.AccountsDatabase;
import Models.Student;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileHelper {
    private static final List<Student> studentList = AccountsDatabase.INSTANCE.getStudentList();

    public static void clearFile(File target, String header) {
        FileWriter writer;
        try {
            // deletes the file
            if (target.delete()) {
                // then create it again and append the header to simulate updating of file
                target.createNewFile();
                writer = new FileWriter(target, true);
                writer.append(header);
                writer.flush();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void replaceFile(String pathOfOldFile, String pathOfNewFile) {
        String sCurrentLine = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathOfOldFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathOfNewFile));

            while ((sCurrentLine = br.readLine()) != null) {
                bw.write(sCurrentLine);
                bw.newLine();
            }

            br.close();
            bw.close();

            // delete the old file
            File org = new File(pathOfOldFile);
            org.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFile(File target, String... contents) {
        try (FileWriter writer = new FileWriter(target, true)) {
            for (String content : contents) {
                writer.append(content);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // To-do list:
    // 1. Function for viewing feedbacks
    // 2. Function for viewing assignments

}
