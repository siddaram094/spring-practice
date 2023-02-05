package com.spring.student.demo.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user;

	public CustomUserDetails(Users user) {
		this.user = user;
	}

	public CustomUserDetails() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		/*
		 * return getAuthorities().stream().map(role -> new
		 * SimpleGrantedAuthority("ROLE_" + role.getAuthority()))
		 * .collect(Collectors.toList());
		 */
		// return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
				return user.getRoles().stream().map(role-> new SimpleGrantedAuthority("ROLE_"+role.getRole())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
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
