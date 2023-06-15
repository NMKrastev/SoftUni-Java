package A1_GringottsDatabase;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;
    @Column(name = "notes", columnDefinition = "TEXT", length = 1000)
    private String notes;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;
    @Column(name = "magic_wand_size")
    private Short magicWandSize;
    @Column(name = "deposit_group", length = 20)
    private String depositGroup;
    @Column(name = "deposit_start_date", columnDefinition = "DATETIME")
    private String depositStartDate;
    @Column(name = "deposit_amount", columnDefinition = "DECIMAL(19, 2)")
    private BigDecimal depositAmount;
    @Column(name = "deposit_interest", columnDefinition = "DECIMAL(19, 2)")
    private BigDecimal depositInterest;
    @Column(name = "deposit_charge", columnDefinition = "DECIMAL(19, 2)")
    private BigDecimal depositCharge;
    @Column(name = "deposit_expiration_date", columnDefinition = "DATETIME")
    private String depositExpirationDate;
    @Column(name = "is_deposit_expired", columnDefinition = "TINYINT")
    private Boolean isDepositExpired;

    protected WizardDeposit() {}

    public WizardDeposit(String lastName, int age) {
        this();
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public Short getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(Short magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public String getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(String depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(BigDecimal depositInterest) {
        this.depositInterest = depositInterest;
    }

    public BigDecimal getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(BigDecimal depositCharge) {
        this.depositCharge = depositCharge;
    }

    public String getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(String depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public Boolean getIsDepositExpired() {
        return isDepositExpired;
    }

    public void setIsDepositExpired(Boolean isDepositExpired) {
        this.isDepositExpired = isDepositExpired;
    }
}
