package com.core.java8.programs;

public class TemplateApp_v1 {

    public static void main(String[] args) {
        TemplateApp_v1 app = new TemplateApp_v1();
        Double amount = 100d;
        //Regular Discount
        RegularDiscount regularDiscount = app.new RegularDiscount();
        regularDiscount.getDiscount(amount);
        //Gold Discount
        GoldDiscount goldDiscount = app.new GoldDiscount();
        goldDiscount.getDiscount(amount);
    }

    abstract class Discount{

        public Double getDiscount(Double amount){
            System.out.println("Calculating the discount for " + this.getClass().getSimpleName());
            Double discount = compute(amount);
            System.out.println("Discount discount is " + discount);
            return discount;
        }

        abstract  protected Double compute(Double amount);

    }

    class RegularDiscount extends Discount {
        protected Double compute(Double amount){
            int TEN = 10;
            return amount/100*TEN;
        }
    }

    class GoldDiscount extends Discount {
        protected Double compute(Double amount){
            int FIFTY = 50;
            return amount/100 * FIFTY;
        }
    }


}

