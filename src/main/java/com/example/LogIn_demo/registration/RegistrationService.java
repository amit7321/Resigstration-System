package com.example.LogIn_demo.registration;

import com.example.LogIn_demo.appuser.AppUser;
import com.example.LogIn_demo.appuser.AppUserRole;
import com.example.LogIn_demo.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService ;
    private final EmailValidator emailValidator ;

    public String register(RegistrationRequest request)
    {
        boolean isValidateEmail = emailValidator.test(request.getEmail()) ;

        if(!isValidateEmail){
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
