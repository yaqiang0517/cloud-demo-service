package com.cloud.order.controller;

import com.cloud.order.dao.repository.RoleRepository;
import com.cloud.product.client.InnerProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceCrossThread;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @author:zyq
 * @create: 2024-05-21 13:26
 * @Description:
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final InnerProductService innerProductService;

    private final RoleRepository roleRepository;

    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;


    @GetMapping("/order/in-create")
    public Boolean inCreateOrder(@RequestParam("productId") Long productId) throws ExecutionException, InterruptedException {
        log.info("------开始创建订单");
//        String orderNo = newOrder(productId);
        log.info("------订单创建成功 orderNo : {}");
        log.info("------开始调用产品");
        InnerProductService.InInventoryParam param = new InnerProductService.InInventoryParam();
        param.setId(productId);
        param.setName("name:" + param.getId());
        var result = innerProductService.inInventory(param);
        log.info("------调用产品结果: {}", result);

        log.info("------开始数据库操作");
        var roles =  roleRepository.list();
        log.info("------数据库操作结果: {}", roles);
//        CompletableFuture.runAsync(
//                new Runnable() {
//            @Override
//            public void run() {
//                var data = OrderController.this.newOrder(123L);
//                log.info("------异步操作结果: {}", data);
//                ;
//            }
//        });
        newOrder(123L);
        var result1 =  CompletableFuture.supplyAsync(new MySupplier());
        log.info("----order " + result1.get());
        return true;
    }

    @GetMapping("/order/create")
    public Boolean createOrder(@RequestParam("productId") Long productId){
        log.info("------开始创建订单");
        String orderNo = newOrder(productId);
        log.info("------订单创建成功");
        log.info("------开始调用产品");
        boolean result = innerProductService.deInventory(productId);
        log.info("------调用产品结果 : " + result);
        return true;
    }


    @TraceCrossThread
    public class MySupplier implements Supplier<String> {
        @Override
        public String get() {
            log.info("------MySupplier : ");
            return "---异步线程测试";
        }
    }

    @Trace(operationName ="newOrder")
    @Tags({
            @Tag(key = "param", value = "arg[0]"),
            @Tag(key = "orderNo", value = "returnedObj")
    })
    @Async
    public String newOrder(Long orderNo){
        log.info("------开始创建订单121212121");
        return "OrderNo:" + orderNo;
    }

}
