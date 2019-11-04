package com.sarika.silkhouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import com.sarika.silkhouse.model.Employee;
import com.sarika.silkhouse.model.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeedaoImpl implements Employeedao {

    @Autowired
    DataSource datasource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EmployeedaoImpl() {

    }

    public EmployeedaoImpl(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    public List<Employee> getall() {
        // TODO Auto-generated method stub
        List<Employee> list;
        String sql = "select employee_id,employee_type,joining_date,holiday,salary from employee";
        list = (List<Employee>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
        return list;
    }

    public void delete(int eid) {
        // TODO Auto-generated method stub
        String sql = "delete from employee where employee_id=" + eid + "";
        String sql2 = "delete from profile where profile_id=" + eid + "";
        jdbcTemplate.update(sql); 
        jdbcTemplate.update(sql2);
    }

    public void update(int quantity, int eid) {
        // TODO Auto-generated method stub
        String sql = "update employee set holiday=" + quantity + " where employee_id=" + eid + "";
        
        jdbcTemplate.update(sql);
    }

    public void save(Profile profile) {
        // TODO Auto-generated method stub
        if(profile.getPhone2()=="")
        {
            String sql="insert into profile set fname=?,lname=?,profile_type=?,phone1=?,email=?";
            Object[] object1= {profile.getFname(),profile.getLname(),0,profile.getPhone1(),profile.getEmail()};
            String sql2="insert into employee set employee_id=?, employee_type=?,joining_date=?,salary=?,adhar_number=?";
            String sql3="select max(profile_id) from profile";
            jdbcTemplate.update(sql,object1);
            Long mx= jdbcTemplate.queryForObject(sql3,Long.class);
            Object[] object2= {mx,profile.getEmployee_type(),profile.getJoining_date(),profile.getSalary(),profile.getAdhar_number()};
            jdbcTemplate.update(sql2,object2);
        }
        else
        {
            String sql="insert into profile set fname=?,lname=?,profile_type=?,phone1=?,phone2=?,email=?";
            Object[] object1= {profile.getFname(),profile.getLname(),0,profile.getPhone1(),profile.getPhone2(),profile.getEmail()};
            String sql2="insert into employee set employee_id=?, employee_type=?,joining_date=?,salary=?,adhar_number=?";
            String sql3=" select max(profile_id) from profile";
            jdbcTemplate.update(sql,object1);
            Long mx= jdbcTemplate.queryForObject(sql3,Long.class);
            Object[] object2= {mx,profile.getEmployee_type(),profile.getJoining_date(),profile.getSalary(),profile.getAdhar_number()};
            jdbcTemplate.update(sql2,object2);
        }

    }
	
}