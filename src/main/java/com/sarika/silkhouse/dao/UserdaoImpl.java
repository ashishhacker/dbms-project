package com.sarika.silkhouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.sarika.silkhouse.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserdaoImpl implements Userdao{
	@Autowired
	@Lazy
    private PasswordEncoder passwordEncoder;
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	

	public UserdaoImpl() {
		
	}
	public UserdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	public void saveOrUpdate(User user) {
		 String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?)";
		 String encrytedPassword = this.passwordEncoder.encode(user.getPassword());
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),encrytedPassword,0,user.getFname(),user.getLname(),
				 user.getPhone() ,user.getEmail(),});
		// System.out.println("EROOR");
	}
	public void delete(String username) {
		String sql = "DELETE FROM user WHERE username=?";
		jdbcTemplate.update(sql,username);
	}
	public User getUser(String username) {
		String sql = "SELECT * FROM user WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
		public User extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUser_type(rs.getInt("user_type"));
				return user;
			}
			return null;
		}
		
	});
}
public User getNumber(String number) {
	String sql = "SELECT * FROM user WHERE phone='"+number+"'";
	return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
	
	public User extractData(ResultSet rs) throws SQLException,DataAccessException{
		if(rs.next()) {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		return null;
	}
	
});
}
}