package com.spring.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserContributor implements InfoContributor {

    @Autowired
    private UserRepo userRepo;
    @Override
    public void contribute(Info.Builder builder) {
        Map<String,Long> userStatusMap = new HashMap<>();
        userStatusMap.put("active",userRepo.getStatus("active"));
        userStatusMap.put("inActive",userRepo.getStatus("inActive"));
         builder.withDetail("userStatus",userStatusMap);
    }
}
