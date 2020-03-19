package com.wwy.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test7 {
    public static void main(String[] args) {
        //第1种
        Double dd = 0.125;
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(df.format(dd));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        //第2种
        MathContext v = new MathContext(2, RoundingMode.HALF_DOWN);
        BigDecimal a = new BigDecimal("0.875", v);
        System.out.println(a);

        //第3种
        float a1 = 123.2354f;
        float b = (float) (Math.round(a1 * 100)) / 100;
        System.out.println(b);

        //第4种
        float ft = 134.3445f;
        int scale = 2;// 设置位数
        int roundingMode = 4;// 表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
        BigDecimal bd = new BigDecimal((double) ft);
        bd = bd.setScale(scale, roundingMode);
        ft = bd.floatValue();
        System.out.println(ft);

        //第5种
        MathContext v2 = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal a2 = new BigDecimal("0.875", v2);
        System.out.println(a2);
    }
}
