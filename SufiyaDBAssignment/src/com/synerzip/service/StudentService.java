package com.synerzip.service;

import java.sql.SQLException;

import com.synerzip.model.StudentModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentService.
 */
public interface StudentService {

	/**
	 * Save.
	 *
	 * @param studentModel the student model
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public void save(StudentModel studentModel) throws SQLException, ClassNotFoundException;
	
	/**
	 * Update.
	 *
	 * @param studentModel the student model
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void update(StudentModel studentModel) throws ClassNotFoundException, SQLException;
	
	/**
	 * Delete.
	 *
	 * @param rollNo the roll no
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void delete(int rollNo) throws ClassNotFoundException, SQLException;
	
	/**
	 * Search.
	 *
	 * @param rollNo the roll no
	 * @return the student model
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public StudentModel search(int rollNo) throws ClassNotFoundException, SQLException;
	
	/**
	 * First entry.
	 *
	 * @return the student model
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	StudentModel firstEntry() throws SQLException, ClassNotFoundException;
	
	/**
	 * Last entry.
	 *
	 * @return the student model
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	StudentModel lastEntry() throws SQLException, ClassNotFoundException; 
	
	/**
	 * Next entry.
	 *
	 * @return the student model
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	StudentModel nextEntry() throws SQLException,ClassNotFoundException;
	
	/**
	 * Previous entry.
	 *
	 * @return the student model
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	StudentModel previousEntry() throws SQLException,ClassNotFoundException;
	
	/**
	 * Result set method.
	 *
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public void resultSetMethod() throws SQLException, ClassNotFoundException; 
	
}
