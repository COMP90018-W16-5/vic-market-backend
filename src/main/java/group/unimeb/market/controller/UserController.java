package group.unimeb.market.controller;

import group.unimeb.market.model.ResponseInfo;
import group.unimeb.market.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("Post a item")
    @PostMapping(value = "/post", produces = "application/json")
    public ResponseInfo postItem() {
        return ResponseInfo.buildSuccess();
    }

    @ApiOperation("Add wishlist item")
    @PostMapping(value = "/wishlist", produces = "application/json")
    public ResponseInfo addWishlist() {
        return ResponseInfo.buildSuccess();
    }

    @ApiOperation("Get wishlist")
    @GetMapping(value = "/wishlist", produces = "application/json")
    public ResponseInfo getWishlist() {
        return ResponseInfo.buildSuccess();
    }
}
