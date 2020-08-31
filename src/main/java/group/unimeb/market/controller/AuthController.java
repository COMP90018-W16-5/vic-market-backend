package group.unimeb.market.controller;

import group.unimeb.market.model.ResponseInfo;
import group.unimeb.market.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private UserService userService;
    @PostMapping("/signup")
    public ResponseInfo registerUser(@RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String displayName) {
        userService.signUpUser(email, password, displayName);
        return ResponseInfo.buildSuccess();
    }
}
