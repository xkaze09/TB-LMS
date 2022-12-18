package Helpers;

import Database.AccountsDatabase;
import Models.Assignment;
import Models.Feedback;
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

    public static void checkForFeedbacks(File feedbacksCSV, List<Feedback> givenFeedbacks) {
        try {
            FileWriter feedbacksCSVWriter;
            if (feedbacksCSV.createNewFile()) {
                feedbacksCSVWriter = new FileWriter(feedbacksCSV, true);
                feedbacksCSVWriter.append("StudentName,TeacherName,Feedback\n");
                feedbacksCSVWriter.flush();
                feedbacksCSVWriter.close();
            } else {
                try (Scanner scanFeeds = new Scanner(feedbacksCSV)) {
                    String header = scanFeeds.nextLine();
                    Student student = null;
                    String line;

                    while (scanFeeds.hasNextLine()) {
                        line = scanFeeds.nextLine();

                        if (line == null)
                            return;
                        if (studentList.size() == 0)
                            return;

                        String[] data = line.split(",");

                        for (var user : studentList) {
                            if (user.getFirstName().equals(data[0])) {
                                student = user;
                                break;
                            }
                        }

                        // if no student matched from the line, we'll check next line
                        if (student == null)
                            break;

                        Feedback feedback = new Feedback(student.getFirstName(), data[1], data[2]);
                        givenFeedbacks.add(feedback);
                        student.getMyController().acceptFeedback(feedback);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Function for viewing assignments
    public static void checkForAssignments(File assignmentsCSV, List<Assignment> givenAssignments) {
        try {
            if (assignmentsCSV.createNewFile()) {
                FileWriter assignmentsCSVWriter = new FileWriter(assignmentsCSV, true);
                assignmentsCSVWriter.append("StudentName,TeacherName,Assignment\n");
                assignmentsCSVWriter.flush();
                assignmentsCSVWriter.close();
            } else {
                try (Scanner scanAssignments = new Scanner(assignmentsCSV)) {
                    String header = scanAssignments.nextLine();
                    Student student = null;
                    String line;

                    while (scanAssignments.hasNextLine()) {
                        line = scanAssignments.nextLine();

                        if (line == null)
                            return;
                        if (studentList.size() == 0)
                            return;

                        String[] data = line.split(",");

                        for (var user : studentList) {
                            if (user.getFirstName().equals(data[0])) {
                                student = user;
                                break;
                            }
                        }

                        // if no student matched from the line, we'll check next line
                        if (student == null)
                            break;

                        Assignment assignment = new Assignment(student.getFirstName(), data[1], data[2]);
                        givenAssignments.add(assignment);
                        student.getMyController().acceptAssignment(assignment);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
