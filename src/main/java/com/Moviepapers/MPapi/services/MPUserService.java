package com.Moviepapers.MPapi.services;

import com.Moviepapers.MPapi.Repositories.MPUserRepository;
import com.Moviepapers.MPapi.models.MPUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MPUserService {
    @Autowired
    MPUserRepository MPUserrepository;
    public MPUser checkIfUserExist(String email){
        return MPUserrepository.findByEmail(email);
    }
}
