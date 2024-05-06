package bankManagement;

import java.io.*;

public class Delete_Account {
    private String accountNumber;

    Delete_Account(String accountNumber){
        this.accountNumber = accountNumber;
        deleteAccount();
    }

    private void deleteAccount() {
        File signupFile = new File("src/bankManagement/Signup.txt");
        File tempFile = new File("src/bankManagement/Temp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(signupFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean isDeleting = false;

            while((currentLine = reader.readLine()) != null) {
                if(currentLine.contains("Account Number: " + accountNumber)) {
                    isDeleting = true;
                }
                if(currentLine.trim().isEmpty()) {
                    isDeleting = false;
                }
                if(!isDeleting) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();

            if (!signupFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(signupFile))
                System.out.println("Could not rename file");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Delete_Account("");
    }
}