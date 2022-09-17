package com.example.icbcmacaudemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.icbcmacaudemo.bean.Bill;
import com.example.icbcmacaudemo.bean.Commodity;
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
        List<Commodity> commodityList = new ArrayList<>();
        List<Integer> qualityList = new ArrayList<>();
        Commodity commodity1 = new Commodity();
        commodity1.setName("苹果");
        commodity1.setSalePrice(8);
        qualityList.add(Integer.parseInt(appleQty));
        commodityList.add(commodity1);

        Commodity commodity2 = new Commodity();
        commodity2.setName("草莓");
        commodity2.setSalePrice(13);
        qualityList.add(Integer.parseInt(strawberryQty));
        commodityList.add(commodity2);

        Commodity commodity3 = new Commodity();
        commodity3.setName("芒果");
        commodity3.setSalePrice(20);
        qualityList.add(Integer.parseInt(mangoQty));
        commodityList.add(commodity3);

        Bill bill = new Bill();
        bill.setCommodityList(commodityList);
        bill.setQualityList(qualityList);

        String flag = "1";
        if (flag.equals(value1) && !flag.equals(value2)) {

        }

        if (!flag.equals(value1) && flag.equals(value2)) {

        }

        if (flag.equals(value1) && flag.equals(value2)) {

        }

        if (!flag.equals(value1) && !flag.equals(value2)){

        }

        JSONObject result = new JSONObject();
        result.put("items", bill);
        return new ResponseEntity<>(JSON.toJSONString(result, SerializerFeature.WriteDateUseDateFormat), HttpStatus.OK);
    }
}
