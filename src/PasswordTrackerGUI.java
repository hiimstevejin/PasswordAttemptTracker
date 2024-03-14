import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import list.LinkedList;

public class PasswordTrackerGUI {
    private LinkedList<String> passwordList = new LinkedList<>();
    private JFrame frame;

    public PasswordTrackerGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Password Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // Create the password field
        JPasswordField passwordField = new JPasswordField(20);


        ActionListener submitAction = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String password = new String(passwordField.getPassword());

                String resultMessage = passwordList.insertAtNext(password);
                JOptionPane.showMessageDialog(frame, resultMessage);
                passwordField.setText(""); // Clear the password field after submitting
            }
        };

        // Create the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(submitAction);

        //submit action to trigger on enter key press
        passwordField.addActionListener(submitAction);

        // Create the view attempts button
        JButton viewAttemptsButton = new JButton("Your Password Attempts");
        viewAttemptsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, passwordList.toString(), "Password Attempts", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JButton saveAttemptsButton = new JButton("save Attempts");
        saveAttemptsButton.addActionListener(e -> saveAttemptsToFile());

        // Add components to the frame
        frame.add(passwordField);
        frame.add(submitButton);
        frame.add(viewAttemptsButton);
        frame.add(saveAttemptsButton);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void saveAttemptsToFile() {
        String directoryPath = ""; // Adjust this path as needed
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it doesn't exist
        }

        String filePath = directoryPath + File.separator + "passwordAttempts.txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(passwordList.toString());
            JOptionPane.showMessageDialog(frame, "Password attempts saved to file: " + filePath);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Failed to save password attempts to file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new PasswordTrackerGUI());
    }

}


