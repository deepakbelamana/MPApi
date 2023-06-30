package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.Repositories.MPUserRepository;
import com.Moviepapers.MPapi.models.MPUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MPUserController {

    @Autowired
    MPUserRepository MPUserRepository;
    @PostMapping("/register")
    public String registerUser(@RequestBody MPUser mpUser){
        try{
            MPUserRepository.save(mpUser);
            return "Success";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody MPUser mpUser){
        try{
            MPUserRepository.updateUserLikedImgInfo(mpUser.getPhone(), mpUser.getLiked());
            return "Success";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
