package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.Repositories.MPUserRepository;
import com.Moviepapers.MPapi.models.MPUser;
import com.Moviepapers.MPapi.services.MPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class MPUserController {

    @Autowired
    MPUserRepository MPUserRepository;
    @Autowired
    MPUserService MPUserService;

    /**
     * registers the user
     * @param mpUser
     * @return
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody MPUser mpUser){
        try{
            if(MPUserService.checkIfUserExist(mpUser.getEmail())!=null){
                return "User already Exists";
            }
            else{
                MPUserRepository.insert(mpUser);
                return "Success";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    /**
     * updates when user likes a image
     * @param mpUser
     * @return
     */
    @PostMapping("/updateLikedInfo")
    public String updateUserLikedInfo(@RequestBody MPUser mpUser){
        try{
            MPUserRepository.updateUserLikedImgInfo(mpUser.getEmail(), mpUser.getLiked());
            return "Success";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody MPUser mpUser){
        try{
           return null;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
