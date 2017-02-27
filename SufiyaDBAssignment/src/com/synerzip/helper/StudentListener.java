package com.synerzip.helper;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import com.synerzip.model.StudentModel;
import com.synerzip.service.StudentService;
import com.synerzip.service.impl.StudentServiceImpl;
import com.synerzip.ui.MyNewFrame;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving student events.
 * The class that is interested in processing a student
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addStudentListener<code> method. When
 * the student event occurs, that object's appropriate
 * method is invoked.
 *
 * @see StudentEvent
 */
public class StudentListener implements ActionListener, WindowListener {

	/** The my frame. */
	private MyNewFrame myFrame;
	
	/** The student model. */
	private StudentModel studentModel;
	
	/** The student service. */
	public static StudentService studentService = new StudentServiceImpl();

	/**
	 * Instantiates a new student listener.
	 *
	 * @param myFrame the my frame
	 */
	public StudentListener(MyNewFrame myFrame) {
		// TODO Auto-generated constructor stub
		this.myFrame = myFrame;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		myFrame.dispose();

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Button button = (Button)actionEvent.getSource();


		String buttonLabel = button.getLabel();
		// TODO Auto-generated method stub
		studentModel = new StudentModel();


		if(buttonLabel.equals("Save")){
			try {

				studentModel.setRollno(Integer.parseInt(myFrame.rollNumberTxt.getText()));
				studentModel.setName(myFrame.nameTxt.getText());
				studentModel.setAddress(myFrame.addresstxt.getText());
				studentModel.setMarks(Float.parseFloat(myFrame.marksTxt.getText()));
				studentModel.setAge(myFrame.age.getSelectedItem());
				studentModel.setGender(myFrame.gender.getSelectedCheckbox().getLabel());

				studentService.save(studentModel);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else
			if(buttonLabel.equals("Update")){
				try {
					studentModel.setRollno(Integer.parseInt(myFrame.rollNumberTxt.getText()));
					studentModel.setName(myFrame.nameTxt.getText());
					studentModel.setAddress(myFrame.addresstxt.getText());
					studentModel.setMarks(Float.parseFloat(myFrame.marksTxt.getText()));
					studentModel.setAge(myFrame.age.getSelectedItem());
					studentModel.setGender(myFrame.gender.getSelectedCheckbox().getLabel());

					studentService.update(studentModel);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(buttonLabel.equals("Delete")){
				try {
					studentService.delete(Integer.parseInt(myFrame.rollNumberTxt.getText()));
					studentService.resultSetMethod();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else if(buttonLabel.equals("Search")){
				try {
					studentModel = studentService.search(Integer.parseInt(myFrame.rollNumberTxt.getText()));
					studentService.resultSetMethod();

					myFrame.rollNumberTxt.setText(String.valueOf(studentModel.getRollno()));
					myFrame.nameTxt.setText(studentModel.getName());
					myFrame.addresstxt.setText(studentModel.getAddress());
					myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
					myFrame.age.select(studentModel.getAge());
					if(studentModel.getGender().equals("Male")){
						myFrame.male.setState(true);
					}
					else 
					{
						myFrame.female.setState(true);
					}


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (buttonLabel.equals("First Entry")) {
				try {
					studentModel = studentService.firstEntry();

					myFrame.rollNumberTxt.setText(String.valueOf(studentModel.getRollno()));
					myFrame.nameTxt.setText(studentModel.getName());
					myFrame.addresstxt.setText(studentModel.getAddress());
					myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
					myFrame.age.select(studentModel.getAge());
					if (studentModel.getGender().equals("Male")) {
						myFrame.male.setState(true);
					} else {
						myFrame.female.setState(true);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (buttonLabel.equals("Last Entry")) {
				try {
					studentModel = studentService.lastEntry();

					myFrame.rollNumberTxt.setText(String.valueOf(studentModel.getRollno()));
					myFrame.nameTxt.setText(studentModel.getName());
					myFrame.addresstxt.setText(studentModel.getAddress());
					myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
					myFrame.age.select(studentModel.getAge());
					if (studentModel.getGender().equals("Male")) {
						myFrame.male.setState(true);
					} else {
						myFrame.female.setState(true);
					}
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else if (buttonLabel.equals("Previous")) {
				try {
					studentModel = studentService.previousEntry();

					myFrame.rollNumberTxt.setText(String.valueOf(studentModel.getRollno()));
					myFrame.nameTxt.setText(studentModel.getName());
					myFrame.addresstxt.setText(studentModel.getAddress());
					myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
					myFrame.age.select(studentModel.getAge());
					if (studentModel.getGender().equals("Male")) {
						myFrame.male.setState(true);
					} else {
						myFrame.female.setState(true);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (buttonLabel.equals("Next")) {
				try {
					studentModel = studentService.nextEntry();

					myFrame.rollNumberTxt.setText(String.valueOf(studentModel.getRollno()));
					myFrame.nameTxt.setText(studentModel.getName());
					myFrame.addresstxt.setText(studentModel.getAddress());
					myFrame.marksTxt.setText(String.valueOf(studentModel.getMarks()));
					myFrame.age.select(studentModel.getAge());
					if (studentModel.getGender().equals("Male")) {
						myFrame.male.setState(true);
					} else {
						myFrame.female.setState(true);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	}
}
