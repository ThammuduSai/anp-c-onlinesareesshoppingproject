package com.onlinesareesshoppingdao;

import com.onlinesareesshopping.entities.Login;

public interface Logindao {
	Login getLoginById(int loginId);
    void updateLogin(int loginid,String email,String password);
}
