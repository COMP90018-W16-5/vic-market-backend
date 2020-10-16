package group.unimeb.market.controller;

import group.unimeb.market.model.*;
import group.unimeb.market.service.ItemService;
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
@RequestMapping("/item")
public class ItemController {
    @Resource
    private ItemService itemService;

    @ApiOperation("Get item list")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseInfo<List<Item>> getItems(@ApiParam(value = "Page number", required = true) @RequestParam Integer page,
                                                 @ApiParam(value = "Number of item per page", required = true) @RequestParam Integer pageSize,
                                                 @ApiParam(value = "Filter by category. Null for all categories", required = false) @RequestParam(required = false) Integer category) {
        return itemService.getItemList(page, pageSize, category);
    }

    @ApiOperation("Get item list near to me")
    @GetMapping(value = "/nearby", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseInfo<List<Item>> getItemsNearBy(@ApiParam(value = "Page number", required = true) @RequestParam Integer page,
                                                 @ApiParam(value = "Number of item per page", required = true) @RequestParam Integer pageSize,
                                                 @ApiParam(value = "Latitude", required = true) @RequestParam BigDecimal latitude,
                                                 @ApiParam(value = "Longitude", required = true) @RequestParam BigDecimal longitude,
                                                 @ApiParam(value = "Max distance (km)", required = true) @RequestParam Integer maxDistance,
                                                 @ApiParam(value = "Filter by category. Null for all categories", required = false) @RequestParam(required = false) Integer category) {
        return itemService.getItemListNearMe(page, pageSize, category, maxDistance, latitude, longitude);
    }

    @ApiOperation("Get item detail")
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo<DetailItem> getItemDetail(@ApiParam(value = "Item id", required = true) @RequestParam("id") Integer id) {
        return ResponseInfo.buildSuccess(itemService.getItemDetail(id));
    }

    @ApiOperation("Search item")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseInfo<List<Item>> searchItem(@ApiParam(value = "Keyword", required = true) @RequestParam String keyword,
                                                   @ApiParam(value = "Page number", required = true) @RequestParam Integer page,
                                                   @ApiParam(value = "Number of item per page", required = true) @RequestParam Integer pageSize) {
        return itemService.getSearchItemList(keyword, page, pageSize);
    }

    @ApiOperation("Get all categories")
    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo<List<Category>> getAllCategories() {
        return ResponseInfo.buildSuccess(itemService.getAllCategories());
    }

    @ApiOperation(value = "Upload images")
    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo<List<ImageUrlModel>> uploadImage(@RequestPart("images") MultipartFile[] images) {
        List<ImageUrlModel> result = new ArrayList<>();
        int seq = 0;
        for (MultipartFile image : images) {
            String url = itemService.uploadFile(image);
            if (url == null || "".equals(url)) {
                continue;
            }
            result.add(new ImageUrlModel(++seq, url));
        }
        return ResponseInfo.buildSuccess(result);
    }

    @ApiOperation("Get random item detail")
    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseInfo<DetailItem> getRandom() {
        return ResponseInfo.buildSuccess(itemService.getRandomItem());
    }
}
