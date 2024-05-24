package com.cloud.product.impl;

import com.cloud.product.client.InnerProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zyq
 * @create: 2024-05-21 13:23
 * @Description:
 */
@Slf4j
@RestController
public class ProductServiceImpl implements InnerProductService {

    @Override
    public Boolean deInventory(@RequestParam("productId") Long productId) {
        log.info("------产品id : " + productId + ", 扣减库存 : " + 1);
        return true;
    }

    @Override
    public InInventoryDTO inInventory(InInventoryParam param) {
        InInventoryDTO dto = new InInventoryDTO();
        dto.setId(param.getId());
        dto.setName(param.getName());
        dto.setCount(1);
        return dto;
    }
}
