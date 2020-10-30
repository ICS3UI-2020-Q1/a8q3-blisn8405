import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
   JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField firstInput;
  JTextField secondInput;

  JButton ftoCButton;
  JButton ctoFButton;

  JTextArea outputArea;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
     //initialize the main JPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);

    //create the side labels
    firstLabel = new JLabel("Degrees Fahrenheit");
    secondLabel = new JLabel("Degrees Celsius");

     //layout the labels by setting the coordinate and size
    //setBounds(x,y,width,height)
    firstLabel.setBounds(50,50,100,30);
    secondLabel.setBounds(50,90,100,30);

    //initialize the input text fields
    firstInput = new JTextField();
    secondInput = new JTextField();

    //set the location and size
    firstInput.setBounds(150,50,75,30);
    secondInput.setBounds(150,90,75,30);

     //initialize the buttons
    ftoCButton = new JButton("F-> C");
    ctoFButton = new JButton("C-> F");
    
     //set the size and location of the buttons
    ftoCButton.setBounds(220,50,70,30);
    ctoFButton.setBounds(220,90,70,30);
    
  
    //add an action listener to the buttons
    ftoCButton.addActionListener(this);
    ctoFButton.addActionListener(this);
   

    //set the action command on the button
    ftoCButton.setActionCommand("F-> C");
    ctoFButton.setActionCommand("C-> F");
  
   //initialize the text Areas
   outputArea = new JTextArea();

   // add to main panel
   mainPanel.add(outputArea);


   //set size and locaiton of text Areas
   outputArea.setBounds(150,50,75,30);

    //add the buttons to the panel
    mainPanel.add(ftoCButton);
    mainPanel.add(ctoFButton);
  

    //add the text fields to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    
    //add the labels to the main pane;
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);

    // add the panel to the window
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
   // get the text from each text boxes
    String firstLabel = firstInput.getText();
     //change the String into an integer
    int Celsius = Integer.parseInt(firstLabel);

 int Fahrenheit = ((Celsius*9)/5 +32);
// output the answer to the user
    if(command.equals("C-> F")){
      outputArea.setText("" + Fahrenheit);
  }
  }
  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
