package com.example.A2_CarDealer.services.customer;

import java.io.IOException;

public interface CustomerService {

    String findAllCustomersAndOrderByCriteria() throws IOException;

    String findAllCustomersWithTotalSalesAndMoneySpent() throws IOException;
}
