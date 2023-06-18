package A6_FootballBettingDatabase;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String username;
    @Column(length = 100)
    private String password;
    @Column
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @Column(columnDefinition = "DECIMAL (19, 2)")
    private BigDecimal balance;
    @OneToMany(mappedBy = "user")
    private Set<Bet> bet;

    public User() {}
}
