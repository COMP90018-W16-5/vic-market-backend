package group.unimeb.market.controller;

import group.unimeb.market.model.Item;
import group.unimeb.market.model.ItemDTO;
import group.unimeb.market.model.ResponseInfo;
import group.unimeb.market.model.User;
import group.unimeb.market.service.ItemService;
import group.unimeb.market.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ItemService itemService;

    @ApiOperation("Post a item")
    @PostMapping(value = "/post", produces = "application/json")
    public ResponseInfo postItem(@RequestBody @ApiParam(value = "Created a post", required = true)ItemDTO item) {
        User user = userService.getCurrentUser();
        itemService.createItem(user, item);
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
