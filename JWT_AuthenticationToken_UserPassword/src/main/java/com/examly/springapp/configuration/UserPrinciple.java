package com.examly.springapp.configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.examly.springapp.model.User;

import lombok.Data;

@Data
public class UserPrinciple implements UserDetails{
    private String username;
    private String password;
    private List<GrantedAuthority> roles;

    public UserPrinciple(){

    }

    public UserPrinciple(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = List.of(new SimpleGrantedAuthority("Role_" + user.getRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }



}
