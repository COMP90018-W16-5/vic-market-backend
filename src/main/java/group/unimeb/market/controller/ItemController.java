package group.unimeb.market.controller;

import group.unimeb.market.model.Item;
import group.unimeb.market.model.PageResponseInfo;
import group.unimeb.market.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping(value = "/list", produces = "application/json")
    public PageResponseInfo<List<Item>> registerUser(@ApiParam(value = "Page number", required = true) @RequestParam Integer page,
                                                     @ApiParam(value = "Number of item per page", required = true) @RequestParam Integer pageSize,
                                                     @ApiParam(value = "Filter by category. Null for all categories", required = false) @RequestParam(required = false) Integer category) {
        return itemService.getItemList(page, pageSize, category);
    }
}
