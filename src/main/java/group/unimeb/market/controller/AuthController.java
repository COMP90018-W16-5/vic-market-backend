package group.unimeb.market.controller;

import group.unimeb.market.model.ResponseInfo;
import group.unimeb.market.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private UserService userService;

    @ApiOperation("User sign up")
    @PostMapping(value = "/signup", produces = "application/json")
    public ResponseInfo registerUser(@RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String displayName) {
        userService.signUpUser(email, password, displayName);
        return ResponseInfo.buildSuccess();
    }
}
