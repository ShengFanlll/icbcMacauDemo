package com.example.icbcmacaudemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.icbcmacaudemo.bean.Bill;
import com.example.icbcmacaudemo.bean.Commodity;
import com.example.icbcmacaudemo.bean.DiscountStrategyFactory;
import com.example.icbcmacaudemo.service.DiscountStrategy;
import com.example.icbcmacaudemo.tool.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("/count")
@RestController
public class CountPriceController {
    @PostMapping("/getPrice")
    public ResponseEntity<String> count(@RequestParam(value = "value1") String value1,
                                        @RequestParam(value = "value2") String value2,
                                        @RequestParam(value = "appleQty") String appleQty,
                                        @RequestParam(value = "strawberryQty") String strawberryQty,
                                        @RequestParam(value = "mangoQty") String mangoQty) {
        JSONObject result = new JSONObject();
        List<Commodity> commodityList = new ArrayList<>();
        List<Integer> qualityList = new ArrayList<>();

        if (Integer.parseInt(appleQty) > 0) {
            Commodity commodity1 = new Commodity();
            commodity1.setName("苹果");
            commodity1.setSalePrice(8);
            qualityList.add(Integer.parseInt(appleQty));
            commodityList.add(commodity1);
        }

        if (Integer.parseInt(strawberryQty) > 0) {
            Commodity commodity2 = new Commodity();
            commodity2.setName("草莓");
            commodity2.setSalePrice(13);
            qualityList.add(Integer.parseInt(strawberryQty));
            commodityList.add(commodity2);
        }


        if (Integer.parseInt(mangoQty) > 0) {
            Commodity commodity3 = new Commodity();
            commodity3.setName("芒果");
            commodity3.setSalePrice(20);
            qualityList.add(Integer.parseInt(mangoQty));
            commodityList.add(commodity3);
        }

        try {
            Bill bill = new Bill();
            if (qualityList.size() > 0) {
                bill.setCommodityList(commodityList);
                bill.setQualityList(qualityList);

                String flag = value1 + value2;
                switch (flag) {
                    case Constant.NORMAL_COUNT:
                        DiscountStrategy normalStrategy = DiscountStrategyFactory.createNormalStrategy();
                        normalStrategy.discountAlgorithm(bill);
                        break;
                    case Constant.DISCOUNT_STRATEGY1_ONLY:
                        DiscountStrategy strategy1 = DiscountStrategyFactory.createStrategy1();
                        strategy1.discountAlgorithm(bill);
                        break;
                    case Constant.DISCOUNT_STRATEGY2_ONLY:
                        DiscountStrategy strategy2 = DiscountStrategyFactory.createStrategy2();
                        strategy2.discountAlgorithm(bill);
                        break;
                    case Constant.DISCOUNT_STRATEGY1_AND_STRATEGY2:
                        DiscountStrategy strategy3 = DiscountStrategyFactory.createStrategy3();
                        strategy3.discountAlgorithm(bill);
                        break;
                }
                result.put("items", bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(JSON.toJSONString(result, SerializerFeature.WriteDateUseDateFormat), HttpStatus.OK);
    }
}
