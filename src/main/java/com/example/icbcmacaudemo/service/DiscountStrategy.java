package com.example.icbcmacaudemo.service;

import com.example.icbcmacaudemo.bean.Bill;
import com.example.icbcmacaudemo.bean.BillDetail;

import java.util.List;

public interface DiscountStrategy {
    Double discountAlgorithm(Bill bill, List<BillDetail> billDetailList) throws Exception;
}
