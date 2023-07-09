package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.Repositories.MPUserRepository;
import com.Moviepapers.MPapi.models.MPUser;
import com.Moviepapers.MPapi.services.MPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class MPUserController {

    @Autowired
    MPUserRepository MPUserRepository;
    @Autowired
    MPUserService MPUserService;

    @Autowired
    PasswordEncoder pwdEncoder;

    /**
     * registers the user
     * @param mpUser
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody MPUser mpUser){
        try{
            if(MPUserService.checkIfUserExist(mpUser.getEmail())!=null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("email already exists, login with same email");
            }
            else{
                /**
                 * encrypting user password before registering
                 * the user
                 */
                mpUser.setPassword(pwdEncoder.encode(mpUser.getPassword()));
                //registering the user.
                MPUserRepository.insert(mpUser);
                return ResponseEntity.ok("registered Successfully, redirecting to login page");
            }
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("unable to register now.!");
        }
    }

    /**
     * updates when user likes a image
     * @param mpUser
     * @return
     */
    @PostMapping("/updateLikedInfo")
    public ResponseEntity updateUserLikedInfo(@RequestBody MPUser mpUser){
        try{
            MPUserRepository.updateUserLikedImgInfo(mpUser.getEmail(), mpUser.getLiked());
            return ResponseEntity.ok("Updated your collection");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("unable to update the likes collection");
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
