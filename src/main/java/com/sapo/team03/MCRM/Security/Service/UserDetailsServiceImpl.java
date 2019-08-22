package com.sapo.team03.MCRM.Security.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Management.Model.Staff;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	StaffDAO staffDAO;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Staff staff = staffDAO.findByEmail(username);
		if(staff == null) {
				throw new UsernameNotFoundException("Staff not found");
		}
		
		return null;
	}

}
