package com.example.sd08_springdataintro.services;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, Long id);

    void depositMoney(BigDecimal amount, Long id);
}
