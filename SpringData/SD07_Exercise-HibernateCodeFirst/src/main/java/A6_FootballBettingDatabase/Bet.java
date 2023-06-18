package A6_FootballBettingDatabase;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bet_money", columnDefinition = "DECIMAL(19, 2)")
    private BigDecimal betMoney;
    @Column(name = "date_time")
    private LocalDate dateTime;
    @ManyToOne
    private User user;

    public Bet() {}


}
