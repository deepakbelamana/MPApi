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
     *
     * @param mpUser
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody MPUser mpUser) {
        try {
            if (MPUserService.checkIfUserExist(mpUser.getEmail()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("email already exists, login with same email");
            } else {
                /**
                 * encrypting user password before registering
                 * the user
                 */
                mpUser.setPassword(pwdEncoder.encode(mpUser.getPassword()));
                //registering the user.
                MPUserRepository.insert(mpUser);
                return ResponseEntity.ok("registered Successfully, redirecting to login page");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("unable to register now.!");
        }
    }

    /**
     * makes the user login
     *
     * @param mpUser
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody MPUser mpUser) {
        try {
            MPUser mpUserFromDB = MPUserService.checkIfUserExist(mpUser.getEmail());
            if (MPUserService.checkIfUserExist(mpUser.getEmail()) != null) {
                if (pwdEncoder.matches(mpUser.getPassword(), mpUserFromDB.getPassword())) {
                    return ResponseEntity.ok("Login Successfully ,redirecting to home page");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid email/password, try again");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not exist, kindly register yourself");
            }
        } catch (Exception exc) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong, try again");
        }

    }

    /**
     * updates when user likes a image
     *
     * @param mpUser
     * @return
     */
    @PostMapping("/updateLikedInfo")
    public ResponseEntity updateUserLikedInfo(@RequestBody MPUser mpUser) {
        try {
            MPUserRepository.updateUserLikedImgInfo(mpUser.getEmail(), mpUser.getLiked());
            return ResponseEntity.ok("Updated your collection");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("unable to update the likes collection");
        }
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody MPUser mpUser) {
        try {
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/resetPwd/sendOTP")
    public ResponseEntity sendOTPtoUserMail (@RequestBody MPUser mpUser) {
        try {
            if (MPUserService.checkIfUserExist(mpUser.getEmail()) != null) {
                return MPUserService.sendOTPtoUserMail(mpUser.getEmail());
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("seems like you need to register first!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a problem sending OTP , Try Again.!");
        }
    }
}
