package group.unimeb.market.controller;

import group.unimeb.market.model.DetailItem;
import group.unimeb.market.model.Item;
import group.unimeb.market.model.PageResponseInfo;
import group.unimeb.market.model.ResponseInfo;
import group.unimeb.market.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
