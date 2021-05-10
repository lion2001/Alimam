package com.client.page;

import Entity.Product;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//class ProductPanel extends JPanel{
//    public ProductPanel(List<Product>products){
//        int m = 0;
//        if(products!=null){
//            int k=products.size();
//            for(int i=0;i<k;i++){
//                if(products.get(i).getIsAuction()==1){
//                    m++;
//                }
//            }
//            if(m%2==0) {
//                m = m/2;
//            }else {
//                m=m/2+1;
//            }
//        }
//        this.setPreferredSize(new Dimension(515,114*m));
//        this.setLayout(new GridLayout(m, 2,5,5));
//        if(products!=null){
//            int size=products.size();
//            for(int i=0;i<size;i++){
//                if(products.get(i).getIsAuction()==1){
//                    this.add(new MyFrame2.browser_everyAuctionPanel(products.get(i)));
//                }
//
//            }
//        }
//    }
//}
