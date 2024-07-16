package org.example;

import java.util.List;

public class Cart {

    private int id;
    private List<Integer> productList;

    public Cart(int clientId, List<Integer> productList) {
        this.id = clientId;
        this.productList = productList;
    }

    public void addProduct(int productId){
        productList.add(productId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getProductList() {
        return productList;
    }

    public void setProductList(List<Integer> productList) {
        this.productList = productList;
    }
}
