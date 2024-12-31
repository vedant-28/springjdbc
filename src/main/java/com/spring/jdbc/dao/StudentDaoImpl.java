package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
		
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		String insertQuery = "INSERT INTO student(id, name, city) VALUES (?, ?, ?)";
		int result = this.jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getCity());
		return result;
	}

	@Override
	public int update(Student student) {
		String updateQuery = "UPDATE student SET name=?, city=? WHERE id=?";
		int result = this.jdbcTemplate.update(updateQuery, "KTY", "A.BAD", 1003);
		return result;
	}

	@Override
	public int delete(int studentId) {
		String deleteQuery = "DELETE FROM student WHERE id=?";
		int result = this.jdbcTemplate.update(deleteQuery, 1003);
		return result;
	}

	// SELECT single object
	@Override
	public Student getStudent(int studentId) {
		
		String selectQuery = "SELECT * FROM student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(selectQuery, rowMapper, studentId);
		
		return student;
	}

	// SELECT multiple objects
	@Override
	public List<Student> getAllStudents() {
		
		String selectQuery = "SELECT * FROM student";
		List<Student> students = this.jdbcTemplate.query(selectQuery, new RowMapperImpl());
		
		return students;
	}
}
