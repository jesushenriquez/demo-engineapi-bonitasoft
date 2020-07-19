package com.example.demo.service;

import org.bonitasoft.engine.api.ApiAccessType;
import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.api.LoginAPI;
import org.bonitasoft.engine.api.TenantAPIAccessor;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserCriterion;
import org.bonitasoft.engine.session.APISession;
import org.bonitasoft.engine.util.APITypeManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EngineService {

    public List<User> getUsers(){
        try {

            Map<String, String> map = new HashMap<String, String>();
            map.put("server.url", "http://localhost:8080");
            map.put("application.name", "bonita");
            APITypeManager.setAPITypeAndParams(ApiAccessType.HTTP, map);

            String username = "walter.bates";
            String password = "bpm";
            LoginAPI loginAPI = TenantAPIAccessor.getLoginAPI();
            APISession apiSession = loginAPI.login(username, password);

            IdentityAPI identityAPI = TenantAPIAccessor.getIdentityAPI(apiSession);
            List<User> users = identityAPI.getUsers(0,50, UserCriterion.USER_NAME_ASC);

            return users;

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
