package com.anacrm.rebeldeswebbackend.model;

public class Negotiation {

    private int buyerId;
    private Inventory buyerOffer;
    private int sellerId;
    private Inventory sellerOffer;

    public Negotiation( int buyerId, Inventory buyerOffer, int sellerId, Inventory sellerOffer){
        this.buyerId=buyerId;
        this.buyerOffer=buyerOffer;
        this.sellerId=sellerId;
        this.sellerOffer= sellerOffer;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public Inventory getBuyerOffer() {
        return buyerOffer;
    }

    public void setBuyerOffer(Inventory buyerOffer) {
        this.buyerOffer = buyerOffer;
    }

    public int getSellerId() {
        return sellerId;
    }

    public Inventory getSellerOffer() {
        return sellerOffer;
    }

    public void setSellerOffer(Inventory sellerOffer) {
        this.sellerOffer = sellerOffer;
    }

}
