package com.Moviepapers.MPapi.services;

import com.Moviepapers.MPapi.Repositories.MPUserRepository;
import com.Moviepapers.MPapi.models.MPUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MPUserService {
    @Autowired
    MPUserRepository MPUserrepository;

    @Autowired
    MPOTPService mpotpService;
    public MPUser checkIfUserExist(String email){
        return MPUserrepository.findByEmail(email);
    }

    public ResponseEntity sendOTPtoUserMail(String userMail){
        return mpotpService.sendOTP(userMail);
    }
}
