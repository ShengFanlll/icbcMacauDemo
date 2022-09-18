package com.example.icbcmacaudemo.service.impl;

import com.example.icbcmacaudemo.bean.Bill;
import com.example.icbcmacaudemo.bean.BillDetail;
import com.example.icbcmacaudemo.bean.Commodity;
import com.example.icbcmacaudemo.service.DiscountStrategy;
import com.example.icbcmacaudemo.util.BigDecimalUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NormalStrategy implements DiscountStrategy {
    @Override
    public Double discountAlgorithm(Bill bill, List<BillDetail> billDetailList) throws Exception {
        List<Double> itemPriceList = getSingleItemCost(bill, billDetailList);
        double sum = 0D;
        for (Double itemPrice : itemPriceList) {
            sum = BigDecimalUtil.add(sum, itemPrice).doubleValue();
        }
        bill.setTotalPrice(sum);
        return sum;
    }

    public List<Double> getSingleItemCost(Bill bill, List<BillDetail> billDetailList) throws Exception {
        List<Commodity> commodities = bill.getCommodityList();
        List<Integer> qualities = bill.getQualityList();
        List<Double> itemPriceList = new ArrayList<>();
        for (int i = 0; i < commodities.size(); i++) {
            BillDetail billDetail = new BillDetail();
            double salePrice = commodities.get(i).getSalePrice();
            double qty = Double.parseDouble(qualities.get(i).toString());
            BigDecimal itemPrice = new BigDecimal(0);
            itemPrice = BigDecimalUtil.mul(salePrice, qty);
            itemPriceList.add(itemPrice.doubleValue());

            billDetail.setCommodityName(commodities.get(i).getName());
            billDetail.setQuality(qualities.get(i));
            billDetail.setItemPrice(itemPrice.doubleValue());
            billDetailList.add(billDetail);
        }
        bill.setItemPriceList(itemPriceList);
        return itemPriceList;
    }
}
