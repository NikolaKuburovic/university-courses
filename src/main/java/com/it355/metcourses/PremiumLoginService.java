package com.it355.metcourses;

/**
 *
 * @author Nikola Kuburovic 1095
 */

import org.springframework.stereotype.Service;

@Service
public class PremiumLoginService {

    public String validateUser(PremiumLoginBean premiumLoginBean) {
        String userName = premiumLoginBean.getUserName();
        String password = premiumLoginBean.getPassword();
        if (userName.equals("premium") && password.equals("premium")) {
            return "true";
        } else {
            return "false";
        }
    }
}

