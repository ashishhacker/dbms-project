package com.sarika.silkhouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import com.sarika.silkhouse.model.Customer;
import com.sarika.silkhouse.model.Profile;
import com.sarika.silkhouse.model.User;

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
public class CustomerdaoImpl implements Customerdao {
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Autowired
    DataSource datasource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CustomerdaoImpl() {

    }

    public CustomerdaoImpl(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    public void addcustomer(Profile profile) {
        // TODO Auto-generated method stub
        if(profile.getPhone2()=="")
        {
            String sql="insert into profile set fname=?,lname=?,profile_type=?,phone1=?,email=?";
            Object[] object1= {profile.getFname(),profile.getLname(),1,profile.getPhone1(),profile.getEmail()};
            String sql2="insert into customer set customer_id=?, house_number=?,pincode=?,state=?";
            String sql3="select max(profile_id) from profile";
            jdbcTemplate.update(sql,object1);
            Long mx= jdbcTemplate.queryForObject(sql3,Long.class);
            Object[] object2= {mx,profile.getHouse_number(),profile.getPincode(),profile.getState()};
            jdbcTemplate.update(sql2,object2);
        }
        else
        {
            String sql="insert into profile set fname=?,lname=?,profile_type=?,phone1=?,phone2=?,email=?";
            Object[] object1= {profile.getFname(),profile.getLname(),1,profile.getPhone1(),profile.getPhone2(),profile.getEmail()};
            String sql2="insert into customer set customer_id=?, house_number=?,pincode=?,state=?";
            String sql3="select max(profile_id) from profile";
            jdbcTemplate.update(sql,object1);
            Long mx= jdbcTemplate.queryForObject(sql3,Long.class);
            Object[] object2= {mx,profile.getHouse_number(),profile.getPincode(),profile.getState()};
            jdbcTemplate.update(sql2,object2);
        }

    }


    public List<Profile> getcustomer() {
        // TODO Auto-generated method stub
         List<Profile> list;
         String sql ="select * from customer";
         list=(List<Profile>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Profile>(Profile.class));
         return list;
    }

 

}