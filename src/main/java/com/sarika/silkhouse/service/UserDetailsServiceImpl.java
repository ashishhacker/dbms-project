package com.sarika.silkhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sarika.silkhouse.dao.Userdao;
import com.sarika.silkhouse.model.User;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private Userdao userdao;

    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        User user = (User)this.userdao.getUser(username);
       
        String str;
        if(user.getUser_type()==1)
        {str="ADMIN";}
        else
        {str="USER";}
        GrantedAuthority authority = new SimpleGrantedAuthority(str.toString());
        grantList.add(authority);
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantList);
        return userDetails;
    }

}