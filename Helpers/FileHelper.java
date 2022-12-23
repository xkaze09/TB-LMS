package Helpers;

// imports from package
import java.io.*;
import java.util.List;
import java.util.Scanner;

// imports from Java
import Database.AccountsDB;
import Models.Feedback;
import Models.Student;
import Models.Assignments;

public class FileHelper {
    private static final List<Student> studentList = AccountsDB.INSTANCE.getStudentList();

    // Deletes the given file and creates a new file with the header appended to it.
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

    // Copies the contents of the given old file to the given new file and then
    // deletes the old file.
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

    // Writes the given contents to the target file.
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

    // Checks the given file for feedbacks and adds them to the given list and
    // updates the student controller.
    public static void checkForFeedbacks(File feedsCSV, List<Feedback> givenFeeds) {
        try {
            FileWriter feedsCSVWriter;
            if (feedsCSV.createNewFile()) {
                feedsCSVWriter = new FileWriter(feedsCSV, true);
                feedsCSVWriter.append("StudentName,TeacherName,Feedback\n");
                feedsCSVWriter.flush();
                feedsCSVWriter.close();
            } else {
                try (Scanner scanFeeds = new Scanner(feedsCSV)) {
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
                        givenFeeds.add(feedback);
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

    // Checks the given file for assignments and adds them to the given list and
    // updates the student controller.
    public static void checkForAssignments(File assignmentsCSV, List<Assignments> givenAssignments) {
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

                        Assignments task = new Assignments(student.getFirstName(), data[1], data[2]);
                        givenAssignments.add(task);
                        student.getMyController().acceptAssignment(task);
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
