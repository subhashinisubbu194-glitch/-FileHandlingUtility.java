import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // File name
    static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("   FILE HANDLING UTILITY");
            System.out.println("=================================");
            System.out.println("1. Create File");
            System.out.println("2. Write to File");
            System.out.println("3. Read File");
            System.out.println("4. Append to File");
            System.out.println("5. Modify File Content");
            System.out.println("6. Clear File Content");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    createFile();
                    break;

                case 2:
                    System.out.print("Enter text to write: ");
                    String writeData = sc.nextLine();
                    writeFile(writeData);
                    break;

                case 3:
                    readFile();
                    break;

                case 4:
                    System.out.print("Enter text to append: ");
                    String appendData = sc.nextLine();
                    appendFile(appendData);
                    break;

                case 5:
                    System.out.print("Enter old word/text: ");
                    String oldText = sc.nextLine();

                    System.out.print("Enter new word/text: ");
                    String newText = sc.nextLine();

                    modifyFile(oldText, newText);
                    break;

                case 6:
                    clearFile();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }

    // Method to create file
    public static void createFile() {
        try {
            File file = new File(FILE_NAME);

            if (file.createNewFile()) {
                System.out.println("File created successfully: " + FILE_NAME);
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("Error creating file.");
            e.printStackTrace();
        }
    }

    // Method to write data into file
    public static void writeFile(String data) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);

            writer.write(data);
            writer.close();

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    // Method to read file
    public static void readFile() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            System.out.println("\n----- FILE CONTENT -----");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("------------------------");

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }

    // Method to append data
    public static void appendFile(String data) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);

            writer.write("\n" + data);
            writer.close();

            System.out.println("Data appended successfully.");

        } catch (IOException e) {
            System.out.println("Error appending file.");
            e.printStackTrace();
        }
    }

    // Method to modify existing content
    public static void modifyFile(String oldText, String newText) {

        try {
            File file = new File(FILE_NAME);

            BufferedReader reader = new BufferedReader(new FileReader(file));

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();

            // Replace old text with new text
            String modifiedContent =
                    content.toString().replace(oldText, newText);

            FileWriter writer = new FileWriter(FILE_NAME);

            writer.write(modifiedContent);
            writer.close();

            System.out.println("File modified successfully.");

        } catch (IOException e) {
            System.out.println("Error modifying file.");
            e.printStackTrace();
        }
    }

    // Method to clear file content
    public static void clearFile() {

        try {
            FileWriter writer = new FileWriter(FILE_NAME);

            writer.write("");
            writer.close();

            System.out.println("File content cleared successfully.");

        } catch (IOException e) {
            System.out.println("Error clearing file.");
            e.printStackTrace();
        }
    }
}
