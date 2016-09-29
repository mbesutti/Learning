package com.mbesutti.badSmell;

 
class Product {
    public int id;
    public int imageId;
    public int unitPrice;
 
    public Product(int prodId, int imageId, int price) {
        this.id = prodId;
        this.imageId = imageId;
        this.unitPrice = price;
    }
 
}
