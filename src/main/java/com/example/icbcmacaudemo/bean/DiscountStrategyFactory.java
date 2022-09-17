package com.example.icbcmacaudemo.bean;

import com.example.icbcmacaudemo.service.DiscountStrategy;
import com.example.icbcmacaudemo.service.impl.ConcreteStrategy3;
import com.example.icbcmacaudemo.service.impl.NormalStrategy;
import com.example.icbcmacaudemo.service.impl.ConcreteStrategy1;
import com.example.icbcmacaudemo.service.impl.ConcreteStrategy2;

public class DiscountStrategyFactory {

    public static DiscountStrategy createNormalStrategy() {
        return new NormalStrategy();
    }
    public static DiscountStrategy createStrategy1() {
        return new ConcreteStrategy1();
    }
    public static DiscountStrategy createStrategy2() {
        return new ConcreteStrategy2();
    }

    public static DiscountStrategy createStrategy3() {
        return new ConcreteStrategy3();
    }
}
