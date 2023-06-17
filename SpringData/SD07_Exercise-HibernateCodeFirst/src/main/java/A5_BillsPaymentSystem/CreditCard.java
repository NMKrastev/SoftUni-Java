package A5_BillsPaymentSystem;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "credit_card_type")
    private CreditCardType creditCardType;
    @Column(name = "expiration_month", nullable = false)
    private Integer expirationMonth;
    @Column(name = "expiration_year", nullable = false)
    private Integer expirationYear;

    public CreditCard() {}

    public Integer getId() {
        return id;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}
