package group.unimeb.market.controller;

import group.unimeb.market.model.ResponseInfo;
import group.unimeb.market.model.User;
import group.unimeb.market.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


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
