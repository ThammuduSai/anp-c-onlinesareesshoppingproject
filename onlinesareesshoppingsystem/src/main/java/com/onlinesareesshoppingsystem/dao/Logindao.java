package com.onlinesareesshoppingsystem.dao;

import com.onlinesareesshoppingsystem.entities.Login;

public interface Logindao {
	Login getLoginById(int loginId);
    void updateLogin(int loginid,String email,String password);
}
