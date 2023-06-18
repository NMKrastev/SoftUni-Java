package A6_FootballBettingDatabase;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column(columnDefinition = "BLOB")
    private String logo;
    @Column(length = 3)
    private String initials;
    @ManyToOne
    @JoinColumn(name = "primary_kit_color", referencedColumnName = "id")
    private Color primaryKitColor;
    @ManyToOne
    @JoinColumn(name = "secondary_kit_column", referencedColumnName = "id")
    private Color secondaryKitColor;
    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;
    @Column
    private BigDecimal budget;

    public Team() {
    }
}
