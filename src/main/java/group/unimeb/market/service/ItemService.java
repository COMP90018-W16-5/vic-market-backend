package group.unimeb.market.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.shape.Rectangle;
import group.unimeb.market.dao.CategoryDao;
import group.unimeb.market.dao.ImageDao;
import group.unimeb.market.dao.ItemCategoryDao;
import group.unimeb.market.dao.ItemDao;
import group.unimeb.market.model.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Yangzhe Xie
 * @date 15/9/20
 */
@Service
public class ItemService {
    @Resource
    private ItemDao itemDao;
    @Resource
    private ImageDao imageDao;
    @Resource
    private ItemCategoryDao itemCategoryDao;
    @Resource
    private CategoryDao categoryDao;

    private List<Integer> allItemId = new ArrayList<>();
    private long lastGetItemIdTime = 0;

    public PageResponseInfo<List<Item>> getItemList(Integer page, Integer pageSize, Integer category) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        List<Item> result;
        if (category == null || category.equals(0)) {
            result = itemDao.selectAll();
        } else {
            result = itemDao.selectByCategory(category);
        }
        PageInfo<Item> pageInfo = new PageInfo<>(result);
        PageResponseInfo<List<Item>> responseInfo = PageResponseInfo.buildSuccess(result);
        responseInfo.setPage(pageInfo.getPageNum());
        responseInfo.setHasNext(pageInfo.isHasNextPage());
        responseInfo.setHasPrevious(pageInfo.isHasPreviousPage());
        return responseInfo;
    }

    public PageResponseInfo<List<Item>> getItemListNearMe(Integer page,
                                                          Integer pageSize,
                                                          Integer category,
                                                          Integer distance,
                                                          BigDecimal latitude,
                                                          BigDecimal longitude) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        Rectangle rectangle = getRectangle(distance, longitude.doubleValue(), latitude.doubleValue());
        BigDecimal minLongitude = BigDecimal.valueOf(rectangle.getMinX());
        BigDecimal maxLongitude = BigDecimal.valueOf(rectangle.getMaxX());
        BigDecimal minLatitude = BigDecimal.valueOf(rectangle.getMinY());
        BigDecimal maxLatitude = BigDecimal.valueOf(rectangle.getMaxY());
        System.out.println(minLongitude + " " + maxLongitude);
        System.out.println(minLatitude + " " + maxLatitude);
        List<Item> result = itemDao.selectNearMe(minLatitude, maxLatitude, minLongitude, maxLongitude, category);
        result = result.stream()
                .filter(a -> getDistance(a.getLongitude().doubleValue(), a.getLatitude().doubleValue(),
                        longitude.doubleValue(), latitude.doubleValue()) <= distance)
                .collect(Collectors.toList());
        PageInfo<Item> pageInfo = new PageInfo<>(result);
        PageResponseInfo<List<Item>> responseInfo = PageResponseInfo.buildSuccess(result);
        responseInfo.setPage(pageInfo.getPageNum());
        responseInfo.setHasNext(pageInfo.isHasNextPage());
        responseInfo.setHasPrevious(pageInfo.isHasPreviousPage());
        return responseInfo;
    }

    public PageResponseInfo<List<Item>> getSearchItemList(String keyword, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        List<Item> result = itemDao.selectSearch("%" + keyword + "%");
        PageInfo<Item> pageInfo = new PageInfo<>(result);
        PageResponseInfo<List<Item>> responseInfo = PageResponseInfo.buildSuccess(result);
        responseInfo.setPage(pageInfo.getPageNum());
        responseInfo.setHasNext(pageInfo.isHasNextPage());
        responseInfo.setHasPrevious(pageInfo.isHasPreviousPage());
        return responseInfo;
    }

    public String uploadFile(MultipartFile image) {
        String url = "https://img.xieyangzhe.com/api.php";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setCharset(StandardCharsets.UTF_8);
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addBinaryBody("upfile", image.getInputStream(), ContentType.MULTIPART_FORM_DATA,
                    image.getOriginalFilename());
            ContentType contentType = ContentType.create("application/json", StandardCharsets.UTF_8);
            builder.addTextBody("token", "joseph");

            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                result = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
                UploadResponse resp = new Gson().fromJson(result, UploadResponse.class);
                return resp.getUrl();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createItem(Item newItem, String image, int category) {
        itemDao.insert(newItem);
        imageDao.insert(new Image(newItem.getItemId(), image));
        ItemCategory itemCategory = new ItemCategory(null, newItem.getItemId(), category);
        itemCategoryDao.insert(itemCategory);
    }

    public DetailItem getItemDetail(Integer itemId) {
        return itemDao.selectDetailItem(itemId);
    }

    public List<Category> getAllCategories() {
        return categoryDao.selectAll();
    }

    private Rectangle getRectangle(double distance, double longitude, double latitude) {
        SpatialContext spatialContext = SpatialContext.GEO;
        return spatialContext.getDistCalc()
                .calcBoxByDistFromPt(spatialContext.makePoint(longitude, latitude),
                        distance * DistanceUtils.KM_TO_DEG, spatialContext, null);
    }


    public DetailItem getRandomItem() {
        if (allItemId.isEmpty() ||
                System.currentTimeMillis() - lastGetItemIdTime > 5 * 60 * 1000) {
            allItemId = itemDao.selectAllItemId();
        }
        lastGetItemIdTime = System.currentTimeMillis();
        int randomIndex = (int)(Math.random() * allItemId.size());
        return getItemDetail(randomIndex);
    }

    public void deleteItem(int itemId, int userId) {
        Item item = itemDao.selectByPrimaryKey(itemId);
        if (item != null && item.getSeller() == userId) {
            itemDao.deleteByPrimaryKey(itemId);
        }
    }

    private static final  double EARTH_RADIUS = 6378137;

    private double rad(double d){
        return d * Math.PI / 180.0;
    }

    public double getDistance(double lon1,double lat1,double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 *Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        return s / 1000;
    }
}
