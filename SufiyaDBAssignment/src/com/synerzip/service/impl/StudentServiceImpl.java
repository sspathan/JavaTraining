package com.synerzip.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.synerzip.helper.DbHelper;
import com.synerzip.model.StudentModel;
import com.synerzip.service.StudentService;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentServiceImpl.
 */
public class StudentServiceImpl implements StudentService {

	/** The ps. */
	java.sql.PreparedStatement ps;
	
	/** The db helper. */
	private DbHelper dbHelper;
	
	/** The student model. */
	private StudentModel studentModel;
	
	/** The result. */
	public ResultSet result;
	
	/**
	 * Instantiates a new student service impl.
	 */
	public StudentServiceImpl() {
		try {
			resultSetMethod();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#save(com.synerzip.model.StudentModel)
	 */
	@Override
	public void save(StudentModel studentModel) throws SQLException, ClassNotFoundException {

		// TODO Auto-generated method stub
		ps = dbHelper.getConnection().prepareStatement("insert into student values(?,?,?,?,?,?)");
		ps.setInt(1, studentModel.getRollno());
		ps.setString(2, studentModel.getName());
		ps.setString(3, studentModel.getAddress());
		ps.setFloat(4, studentModel.getMarks());
		ps.setString(5, studentModel.getAge());
		ps.setString(6, studentModel.getGender());
		ps.execute();
	}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#update(com.synerzip.model.StudentModel)
	 */
	public void update(StudentModel studentModel) throws ClassNotFoundException, SQLException{
		
		// TODO Auto-generated method stub
		ps = dbHelper.getConnection().prepareStatement("update student set name=?, address=?, marks=?, age=?, gender=? where rollno=? ");
		ps.setString(1,studentModel.getName());
		ps.setString(2, studentModel.getAddress());
		ps.setFloat(3, studentModel.getMarks());
		ps.setString(4, studentModel.getAge());
		ps.setString(5,  studentModel.getGender());
		ps.setInt(6,studentModel.getRollno());
		
		ps.execute();
		}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#delete(int)
	 */
	public void delete(int rollNo) throws ClassNotFoundException, SQLException{
		
		// TODO Auto-generated method stub
		ps = dbHelper.getConnection().prepareStatement("delete from student  where rollno="+rollNo);
		ps.executeUpdate();
	}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#search(int)
	 */
	@Override
	public StudentModel search(int rollNo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String query="select rollno,name,address,marks,age,gender from student where rollno ="+rollNo;
		Statement statement= dbHelper.getConnection().createStatement();
		ResultSet rs;
		rs=statement.executeQuery(query);
		
		if(rs!= null){
			studentModel = new StudentModel();
			while(rs.next()){
				studentModel.setRollno(rs.getInt("rollno"));
				studentModel.setName(rs.getString("name"));
				studentModel.setAddress(rs.getString("address"));
				studentModel.setMarks(rs.getFloat("marks"));
				studentModel.setAge(rs.getString("age"));
				studentModel.setGender(rs.getString("gender"));
			}
		}
		return studentModel;	
	}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#firstEntry()
	 */
	@Override
	public StudentModel firstEntry() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
			
		
		if (result.first()) {
			studentModel = new StudentModel();
			studentModel.setRollno(result.getInt("rollno"));
			studentModel.setName(result.getString("name"));
			studentModel.setAddress(result.getString("address"));
			studentModel.setMarks(result.getFloat("marks"));
			studentModel.setAge(result.getString("age"));
			studentModel.setGender(result.getString("gender"));

		}
		return studentModel;
		
	}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#lastEntry()
	 */
	@Override
	public StudentModel lastEntry() throws SQLException {
		// TODO Auto-generated method stub
		
		if (result.last()) {
			studentModel = new StudentModel();
			studentModel.setRollno(result.getInt("rollno"));
			studentModel.setName(result.getString("name"));
			studentModel.setAddress(result.getString("address"));
			studentModel.setMarks(result.getFloat("marks"));
			studentModel.setAge(result.getString("age"));
			studentModel.setGender(result.getString("gender"));

		}
		return studentModel;
		
	}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#nextEntry()
	 */
	@Override
	public StudentModel nextEntry() throws SQLException {
		// TODO Auto-generated method stub
		
		if (!result.isLast() && result.next()) {
			studentModel = new StudentModel();
			studentModel.setRollno(result.getInt("rollno"));
			studentModel.setName(result.getString("name"));
			studentModel.setAddress(result.getString("address"));
			studentModel.setMarks(result.getFloat("marks"));
			studentModel.setAge(result.getString("age"));
			studentModel.setGender(result.getString("gender"));

		}
		return studentModel;
	
	}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#previousEntry()
	 */
	@Override
	public StudentModel previousEntry() throws SQLException {
		// TODO Auto-generated method stub
		if (!result.isBeforeFirst() && !result.isFirst() && result.previous()) {
			studentModel = new StudentModel();
			studentModel.setRollno(result.getInt("rollno"));
			studentModel.setName(result.getString("name"));
			studentModel.setAddress(result.getString("address"));
			studentModel.setMarks(result.getFloat("marks"));
			studentModel.setAge(result.getString("age"));
			studentModel.setGender(result.getString("gender"));

		}
		return studentModel;
	}
	
	/* (non-Javadoc)
	 * @see com.synerzip.service.StudentService#resultSetMethod()
	 */
	public void resultSetMethod() throws SQLException, ClassNotFoundException {

		String chkquery = "select * from student";
		Statement statement = dbHelper.getConnection().createStatement();

		result = statement.executeQuery(chkquery);

		if (result != null) {
			studentModel = new StudentModel();
			result.beforeFirst();

		}

	}

	
	

}
