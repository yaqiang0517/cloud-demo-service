package com.cloud.product.fallback;

import com.cloud.product.client.InnerProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author:zyq
 * @create: 2024-05-21 13:18
 * @Description:
 */
@Slf4j
@Service
public class InnerProductServiceFallback implements InnerProductService {

    @Override
    public Boolean deInventory(Long productId) {
        log.info("------ product deInventory 降级------");
        return Boolean.TRUE;
    }

    @Override
    public InInventoryDTO inInventory(InInventoryParam param) {
        log.info("------ product inInventory 降级------");
        return null;
    }
}
