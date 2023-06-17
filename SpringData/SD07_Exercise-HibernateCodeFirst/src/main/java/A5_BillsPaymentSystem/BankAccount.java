package A5_BillsPaymentSystem;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(name = "swift_code", nullable = false)
    private String SWIFTCode;

    public BankAccount() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public void setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
    }
}
