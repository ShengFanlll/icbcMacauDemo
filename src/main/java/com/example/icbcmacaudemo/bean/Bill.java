package com.example.icbcmacaudemo.bean;

import com.example.icbcmacaudemo.util.BigDecimalUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Bill {

    private List<Commodity> commodityList;

    private List<Integer> qualityList;

    private List<Double> itemPriceList;

    private double totalPrice;

    /*
    public void getSingleItemCost(List<Commodity> commodity, List<Integer> quality) {
        List<Double> itemPriceList = new ArrayList<>();
        for (int i = 0; i < commodity.size(); i++) {
            double salePrice = commodity.get(i).getSalePrice();
            double qty = Double.parseDouble(quality.get(i).toString()) ;
            BigDecimal itemPrice = new BigDecimal(0);
            itemPrice = BigDecimalUtil.mul(salePrice, qty);
            itemPriceList.add(itemPrice.doubleValue());
        }
        this.itemPriceList = itemPriceList;
    }

    public void getTotalCost(List<Double> itemPriceList) {
        double sum = 0D;
        for (Double itemPrice : itemPriceList) {
            sum = BigDecimalUtil.add(sum, itemPrice).doubleValue();
        }
        discount(sum);
    }

    public void discount(double totalCost) {
        this.totalPrice = totalCost;
    }

     */

}
