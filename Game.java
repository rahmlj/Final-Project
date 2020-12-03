import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.util.ArrayList;
import java.io.*;

class Game implements ActionListner {
  //Declaring Variables necessary
  JLabel lblWelcome, lblEnterName;
  JTextField field1;
  JLabel lblQuestion;
  JLabel lblScore;
  JButton btnNextQuestion, btnRestart, btnEnterName, btnSubmit;
  JLabel lblPrompt;
  JFrame frame;
  JPanel pnl1, pnl2, pnl3, pnl4, pnl5, pnl6;
  JPanel pnlQuestions, pnlMaster, pnlControl;
  
  //Derclaring Variables necessary cont.
  ArrrayList<Question> QuestionList;
  ArrayList<JButton> AnswerList;
  int idex;
  int score;
  String pName;
  
  
  
  Game(){
    //Setting base values
    pName = "";
    index = 0;
    score = 0;
    
    AnswerList =  new ArrayList<JButton>();
    QuestionList = new ArrayList<Question>();
   
   try{
     //Read in Questions from trivia.txt field
     FileReader myFile = new FileReader("trivia.txt");
     Bufferedreader reader = new BufferedReader(myFile);
     
     while (reader.ready()){
        for(int i = 0; i<=4; i++){

         //Reading the lines in order
         String questText = reader.readLine();
         String optionA = reader.readLine();
         String optionB = reader.readLine();
         String optionC = reader.readLine();
         String optionD = reader.readLine();
         
         //Converting the Integers to Strings so they can be Read
         int correctAns = Integer.parseInt(correctAnsString);
         String correctAnString = reader.readLine();
        
         int points = Integer.parseInt(pointsString);
         String pointsString = reader.readLine();

         //Pulling all relevant information for our Question and adding it to the Question List

         Question quest = new Question(questText, optionA, optionB, optionC, optionD, correctrAns, points);
         
         
         QuestionList.add(quest);
        }
      }

      reader.close();
    }

    catch (IOException exception){
      System.out.println("An error occured: " + exception);

    }

    //Creating Window with Title
    frame = new JFrame("Guess that Team's Name the Trivia Game");
    frame.setLayout(new BorderLayout());
    frame.setSize(800,400);
    
    //Welcome Label Text
    lblWelcome = new JLabel("Welcome to the Team Naming Game!");
    //Name Collection
    lblEnterName = new JLabel("Enter your Name:  ");
    btnEnterName = new JButton("Enter");
    btnEnterName.addActionListener(this);
    field1 = new JTextField(10);
    field1.setActionCommand("myTF");
    field1.addActionListener(this);

    //Add Questions
    lblQuestion = new JLabel(QuestionList.get(index).getQuestText() + " (Worth " + QuestionList.get(index).getPoints() + " Points)");

    lblPrompt = new JLabel("");

    //Potential Answer Buttons

    AnswerList.add(new JButton(QuestionList.get(index).getOptionA()));
    AnswerList.add(new JButton(QuestionList.get(index).getOptionB()));
    AnswerList.add(new JButton(QuestionList.get(index).getOptionC()));
    AnswerList.add(new JButton(QuestionList.get(index).getOptionD()));

    //Show Current Score
    lblScore = new JLabel("Current Score: " + score);

    //Buttons for Next Question, Restart, and Submit Score
    btnNextQuestion = new JButton("Next Question");
    btnNextQuestion.addActionListener(this);
    btnRestart = new JButton("Restart");
    btnRestart.addActionListener(this);
    btnSubmit = new JButton("Submit Score");
    btnSubmit.addActionListener(this);
    //Setting the layout for all panels needed
    pnl1 = new JPanel(new FlowLayout());
    pnl2 = new JPanel(new FlowLayout());
    pnl3 = new JPanel(new FlowLayout());
    pnl4 = new JPanel(new FlowLayout());
    pnl5 = new JPanel(new FlowLayout());
    pnl6 = new JPanel(new FlowLayout());
    pnlMaster = new JPanel(new FlowLayout());

    pnl1.add(lblWelcome);
    pnl2.add(lblPrompt);
    pnl2.add(field1);
    pnl2.add(btnEnterName);
    pnl3.add(lblQuestion);
      for (int i = 0; i < 4; i++){
        AnswerList.get(i).addActionListener(this);
        pnl4.add(AnswerList.get(i));
      }
    pnl5.add(lblPrompt);
    pnl5.add(lblScore);
    pnl6.add(btnNextQuestion);
    pnl6.add(btnSubmit);
    btnSubmit.addActionListener(this);
    pnl6.add(btnRestart);

    pnlMaster.add(pnl1);
    pnlMaster.add(pnl2);
    pnlMaster.add(pnl3);
    pnlMaster.add(pnl4);
    pnlMaster.add(pnl5);
    pnlMaster.add(pnl6);
    frame.add(pnlMaster);

    frame.setVisible(true);


  } 


  public void actionPerformed(ActionEvent ae){
    
  }
}