package com.onlinesareesshoppingsystem.dao;

import java.util.List;

import com.onlinesareesshoppingsystem.entities.Admin;

public interface Admindao {
    void insert(Admin admin); 
    Admin getAdminByEmailAndPassword(String email, String password);
    void update(int adminid,String adminname,String email);
    void delete(int adminid);
    List<Admin> select();
	void search(int adminid);
}
