package com.synerzip.ui;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.synerzip.helper.StudentListener;

// TODO: Auto-generated Javadoc
/**
 * The Class MyNewFrame.
 */
public class MyNewFrame extends Frame  {

  /** The roll number txt. */
  public TextField rollNumberTxt;
  
  /** The name txt. */
  public TextField nameTxt;
  
  /** The marks txt. */
  public TextField marksTxt;
  
  /** The roll number lbl. */
  public Label rollNumberLbl;
  
  /** The name lbl. */
  public Label nameLbl;
  
  /** The marks lbl. */
  public Label marksLbl;
  
  /** The address lbl. */
  public Label addressLbl;
  
  /** The age lbl. */
  public Label ageLbl;
  
  /** The gender lbl. */
  public Label genderLbl;
  
  /** The addresstxt. */
  public TextArea addresstxt;
  
  /** The age. */
  public Choice age;
  
  /** The gender. */
  public CheckboxGroup gender ;
  
  /** The male. */
  public Checkbox male;
  
  /** The female. */
  public Checkbox female;
  
  /** The save. */
  public Button save;
  
  /** The update. */
  public Button update;
  
  /** The delete. */
  public Button delete;
  
  /** The search. */
  public Button search;
  
  /** The first. */
  public Button first;
  
  /** The prev. */
  public Button prev;
  
  /** The next. */
  public Button next;
  
  /** The last. */
  public Button last;

  /** The buttonhandler. */
  StudentListener buttonhandler;
  
  /**
   * Instantiates a new my new frame.
   *
   * @param title the title
   */
  public MyNewFrame(String title) {
    this.setBounds(100, 100, 700, 700);
    setVisible(true);
    setTitle(title);
    setLayout(null);
    setBackground(Color.lightGray);
    
    
    rollNumberLbl = new Label("Roll No");
    rollNumberLbl.setBounds(100, 100, 100, 15);
    add(rollNumberLbl);
    
    rollNumberTxt = new TextField();
    rollNumberTxt.setBounds(200, 100, 100, 20);
 
    add(rollNumberTxt);
    
    nameLbl = new Label("Name");
    nameLbl.setBounds(100, 150, 100, 20);
    add(nameLbl);
    
    nameTxt = new TextField();
    nameTxt.setBounds(200, 150, 100, 20);
    add(nameTxt);

    addressLbl = new Label("Address");
    addressLbl.setBounds(100, 200, 100, 20);
    add(addressLbl);
    
    addresstxt = new TextArea();
    addresstxt.setBounds(200, 200, 200, 80);
    add(addresstxt);
    
    marksLbl = new Label("Marks");
    marksLbl.setBounds(100, 300, 100, 20);
    add(marksLbl);
    
    marksTxt = new TextField();
    marksTxt.setBounds(200, 300, 100, 20);
    add(marksTxt);
    
    ageLbl = new Label("Age");
    ageLbl.setBounds(100, 350, 100, 20);
    add(ageLbl);
    
    age = new Choice();
    age.add("20");
    age.add("21");
    age.add("22");
    age.add("23");
    age.add("24");
    age.add("25");
    age.setBounds(200, 350, 100, 20);
    age.setBackground(Color.white);
    add(age);
    
    genderLbl = new Label("Gender");
    genderLbl.setBounds(100, 400, 100, 20);
    add(genderLbl);
    gender = new CheckboxGroup();
    
    male =new Checkbox("Male",gender, true);
    male.setBounds(200, 400, 100, 20);
    add(male);
   // male.setBackground(Color.white);
    
    female =new Checkbox("Female",gender, false);
    female.setBounds(300, 400, 100, 20);
    add(female);
  //  female.setBackground(Color.white);
    
    Button save = new Button("Save");
    save.setBounds(100, 500, 80, 30);
    save.addActionListener(new StudentListener(this));
    add(save);

    Button update = new Button("Update");
    update.setBounds(200, 500, 80, 30);
    update.addActionListener(new StudentListener(this));
    add(update);

    Button delete = new Button("Delete");
    delete.setBounds(300, 500, 80, 30);
    delete.addActionListener(new StudentListener(this));
    add(delete);
    
    Button search = new Button("Search");
    search.setBounds(100, 600, 80, 30);
    search.addActionListener(new StudentListener(this));
    add(search);
    
    Button firstEntry = new Button("First Entry");
    firstEntry.setBounds(200, 600, 80, 30);
    firstEntry.addActionListener(new StudentListener(this));
    add(firstEntry);
    
    Button lastEntry = new Button("Last Entry");
    lastEntry.setBounds(300, 600, 80, 30);
    lastEntry.addActionListener(new StudentListener(this));
    add(lastEntry);
    
    Button next = new Button("Next");
    next.setBounds(400, 600, 80, 30);
    next.addActionListener(new StudentListener(this));
    add(next);
    
    Button previous = new Button("Previous");
    previous.setBounds(500, 600, 80, 30);
    previous.addActionListener(new StudentListener(this));
    add(previous);
    
    buttonhandler = new StudentListener(this);
   addWindowListener(buttonhandler);
 
  }


 
}
