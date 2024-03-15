import java.util.Scanner;

/* this is a multiline comment :0
Everything needs a class matching the filename   */
public class AutoMindustry {
    public static void main(String[] args){                  // Every class needs a main function or smt
        //downloads and stuff
        String latestServer = "https://github.com/Anuken/Mindustry/releases/latest/download/Mindustry.jar";
        System.out.println("Welcome to AutoMindustry :)"); // Use 'System.out.print()' to prevent newlines

        Scanner readLine = new Scanner(System.in); // Create a scanner object to read user input
        System.out.print("1. Download latest Mindustry jar \n2. Use custom jar file\n\n>>  ");
        // Read user input
        int choice = readLine.nextInt();
        //if user wants to download latest jar download the jar from the latestServer and save it as Mindustry.jar
        if (choice == 1){
            System.out.println("Downloading latest Mindustry jar...");
            try {
                java.io.BufferedInputStream in = new java.io.BufferedInputStream(new java.net.URL(latestServer).openStream());
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream("Mindustry.jar");
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
                fileOutputStream.close(); // Close the FileOutputStream to prevent mem leak
                System.out.println("Download complete!");
            } catch (java.io.IOException e) {
                System.out.println("Error downloading Mindustry jar: " + e);
            }
        } else {
            System.out.print("Enter the path to the jar file: ");
            String path = readLine.next();
            System.out.println("Using custom jar file...");
            try {
                java.io.File file = new java.io.File(path);
                if (file.exists()){
                    java.nio.file.Files.copy(file.toPath(), new java.io.File("Mindustry.jar").toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Jar file copied successfully!");
                } else {
                    System.out.println("File does not exist!");
                }
            } catch (java.io.IOException e) {
                System.out.println("Error using custom jar file: " + e);
            }
        }
        readLine.close(); // Close the scanner object to prevent mem leak
    }
}
