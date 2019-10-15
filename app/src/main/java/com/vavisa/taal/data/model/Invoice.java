package com.vavisa.taal.data.model;

public class Invoice {

    private Case requestCase;
    private Quotation quotation;
    private User user;
    private Address address;

    public Invoice(User user) {
        this.user = user;
    }

    public Case getRequestCase() {
        return requestCase;
    }

    public void setRequestCase(Case requestCase) {
        this.requestCase = requestCase;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
