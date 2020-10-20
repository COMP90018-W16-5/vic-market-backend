package group.unimeb.market.controller;

import group.unimeb.market.model.*;
import group.unimeb.market.service.ItemService;
import group.unimeb.market.service.UserService;
import group.unimeb.market.service.WishlistService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    public ResponseInfo<?> postItem(@ApiParam(value = "Item title", required = true) @RequestParam String title,
                                    @ApiParam(value = "Item description", required = true) @RequestParam String description,
                                    @ApiParam(value = "Item image", required = true) @RequestParam String image,
                                    @ApiParam(value = "Item category", required = true) @RequestParam int category,
                                    @ApiParam(value = "Item latitude", required = true) @RequestParam double latitude,
                                    @ApiParam(value = "Item longitude", required = true) @RequestParam double longitude,
                                    @ApiParam(value = "Item address", required = true) @RequestParam String address,
                                    @ApiParam(value = "Item price", required = true) @RequestParam double price) {
        User user = userService.getCurrentUser();
        Item newItem = new Item();
        newItem.setTitle(title);
        newItem.setDescription(description);
        newItem.setLatitude(BigDecimal.valueOf(latitude));
        newItem.setLongitude(BigDecimal.valueOf(longitude));
        newItem.setPrice(price);
        newItem.setSeller(user.getUid());
        newItem.setStatus(0);
        newItem.setAddress(address);
        itemService.createItem(newItem, image, category);
        return ResponseInfo.buildSuccess();
    }

    @ApiOperation("Add wishlist item")
    @PostMapping(value = "/wishlist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo<?> addWishlist(@ApiParam(value = "Item id", required = true) @RequestParam Integer itemId) {
        User user = userService.getCurrentUser();
        WishList wishList = new WishList(user.getUid(), itemId);
        wishlistService.addWishlistItem(wishList);
        return ResponseInfo.buildSuccess();
    }

    @ApiOperation("Delete wishlist item")
    @DeleteMapping(value = "/wishlist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo<?> deleteWishlist(@ApiParam(value = "Item id", required = true) @RequestParam Integer itemId) {
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

    @ApiOperation("Delete published item")
    @DeleteMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo<?> deleteItem(@ApiParam(value = "Item id", required = true) @RequestParam Integer itemId) {
        User user = userService.getCurrentUser();
        itemService.deleteItem(itemId, user.getUid());
        return ResponseInfo.buildSuccess();
    }

    @ApiOperation("Get items posted by the current user")
    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseInfo<List<Item>> getItems(@ApiParam(value = "Page number", required = true) @RequestParam Integer page,
                                                 @ApiParam(value = "Number of item per page", required = true) @RequestParam Integer pageSize) {
        User user = userService.getCurrentUser();
        return itemService.getUserItemList(user.getUid(), page, pageSize);
    }
}
