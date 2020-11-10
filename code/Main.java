import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args){
        // List of distance measurement units
        String[] units = {"MILES", "KILOMETRES", "METRES", "YARDS"};

        // Creating frame
        JFrame jFrame = new JFrame("Distance Converter");

        // Creating panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Creating combo box
        JLabel convertFromLabel = new JLabel("Converting from:");
        JComboBox<String> distanceListFrom = new JComboBox<>(units);
        distanceListFrom.setSelectedIndex(0);
        JLabel convertToLabel = new JLabel("Converting to: ");
        JComboBox<String> distanceListTo = new JComboBox<>(units);
        distanceListTo.setSelectedIndex(1);
        JLabel resultLabel = new JLabel("------------");
        JTextField convertFromText = new JTextField(7); // 7 columns in the text field
        JButton convertButton = new JButton("CONVERT");

        // Adding graphics objects to the panel
        panel.add(convertFromLabel);
        panel.add(distanceListFrom);
        panel.add(convertFromText);
        panel.add(convertToLabel);
        panel.add(distanceListTo);
        panel.add(resultLabel);
        panel.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Initialising important variables
                double convertFromValue, convertToValue;

                try {
                    // Checking what distance units we are converting to and from
                    String distanceFrom = (String) distanceListFrom.getSelectedItem();
                    String distanceTo = (String) distanceListTo.getSelectedItem();
                    convertFromValue = Double.parseDouble(convertFromText.getText());
                    assert distanceFrom != null && distanceTo != null;
                    if (distanceFrom.equals("MILES") && distanceTo.equals("KILOMETRES")){
                        convertToValue = 1.60934 * convertFromValue;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("MILES") && distanceTo.equals("METRES")){
                        convertToValue = 1609.34 * convertFromValue;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("MILES") && distanceTo.equals("YARDS")){
                        convertToValue = 1760 * convertFromValue;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("KILOMETRES") && distanceTo.equals("MILES")){
                        convertToValue = convertFromValue / 1.60934;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("KILOMETRES") && distanceTo.equals("METRES")){
                        convertToValue = convertFromValue * 1000;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("KILOMETRES") && distanceTo.equals("YARDS")){
                        convertToValue = convertFromValue * 1093.61;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("METRES") && distanceTo.equals("MILES")){
                        convertToValue = convertFromValue / 1609.34;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("METRES") && distanceTo.equals("KILOMETRES")){
                        convertToValue = convertFromValue / 1000;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("METRES") && distanceTo.equals("YARDS")){
                        convertToValue = convertFromValue * 1.09361;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("YARDS") && distanceTo.equals("MILES")){
                        convertToValue = convertFromValue / 1760;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("YARDS") && distanceTo.equals("KILOMETRES")){
                        convertToValue = convertFromValue / 1093.61;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                    else if (distanceFrom.equals("YARDS") && distanceTo.equals("METRES")){
                        convertToValue = convertFromValue / 1.09361;
                        resultLabel.setText(Double.toString(convertToValue));
                    }
                }

                catch (Exception ex){
                    // Do nothing
                }
            }
        });

        // Adding the panel to the frame
        jFrame.add(panel);

        // Setting size of the window
        jFrame.setSize(800, 640);

        // Making the frame visible
        jFrame.setVisible(true);
    }
}
