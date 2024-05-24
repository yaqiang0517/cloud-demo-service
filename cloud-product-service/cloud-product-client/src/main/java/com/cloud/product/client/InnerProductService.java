package com.cloud.product.client;

import com.cloud.product.fallback.InnerProductServiceFallback;
import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author:zyq
 * @create: 2024-05-21 13:17
 * @Description:
 */
@FeignClient(value = "cloud-product-service", fallback = InnerProductServiceFallback.class)
public interface InnerProductService {

    /**
     * 扣减库存
      * @param productId
     * @return
     */
    @GetMapping("/product/de-inventory")
    Boolean deInventory(@RequestParam("productId") Long productId);

    @Data
    class InInventoryParam{
        private Long id;
        private String name;
    }

    @Data
    class InInventoryDTO{
        private Long id;
        private String name;
        private Integer count;
    }


    @PostMapping("/product/in-inventory")
    InInventoryDTO inInventory(@RequestBody InInventoryParam param);
}
