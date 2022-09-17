package com.example.icbcmacaudemo.service;

import com.example.icbcmacaudemo.bean.Bill;

public interface DiscountStrategy {
    Double discountAlgorithm(Bill bill);
}
