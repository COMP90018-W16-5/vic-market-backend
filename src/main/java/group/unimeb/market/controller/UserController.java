package group.unimeb.market.controller;

import group.unimeb.market.model.*;
import group.unimeb.market.service.ItemService;
import group.unimeb.market.service.UserService;
import group.unimeb.market.service.WishlistService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ItemService itemService;
    @Resource
    private WishlistService wishlistService;

    @ApiOperation("Post a item")
    @PostMapping(value = "/post", produces = "application/json")
    public ResponseInfo postItem(@RequestBody @ApiParam(value = "Created a post", required = true)ItemDTO item) {
        User user = userService.getCurrentUser();
        itemService.createItem(user, item);
        return ResponseInfo.buildSuccess();
    }

    @ApiOperation("Add wishlist item")
    @PostMapping(value = "/wishlist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo addWishlist(@ApiParam(value = "Item id", required = true) @RequestParam Integer itemId) {
        User user = userService.getCurrentUser();
        WishList wishList = new WishList(user.getUid(), itemId);
        wishlistService.addWishlistItem(wishList);
        return ResponseInfo.buildSuccess();
    }

    @ApiOperation("Delete wishlist item")
    @DeleteMapping(value = "/wishlist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo deleteWishlist(@ApiParam(value = "Item id", required = true) @RequestParam Integer itemId) {
        User user = userService.getCurrentUser();
        WishList wishList = new WishList(user.getUid(), itemId);
        wishlistService.removeWishlistItem(wishList);
        return ResponseInfo.buildSuccess();
    }

    @ApiOperation("Get wishlist")
    @GetMapping(value = "/wishlist", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseInfo<List<Item>> getWishlist(@ApiParam(value = "Page number", required = true) @RequestParam Integer page,
                                    @ApiParam(value = "Number of item per page", required = true) @RequestParam Integer pageSize) {
        User user = userService.getCurrentUser();
        return wishlistService.getWishlist(page, pageSize, user.getUid());
    }
}
