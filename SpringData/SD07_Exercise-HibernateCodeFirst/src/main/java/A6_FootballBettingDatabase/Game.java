package A6_FootballBettingDatabase;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "home_team")
    private Team homeTeam;
    @OneToOne
    @JoinColumn(name = "away_team")
    private Team awayTeam;
    @Column(name = "home_team_goals")
    private Integer homeTeamGoals;
    @Column(name = "away_team_goals")
    private Integer awayTeamGoals;
    @Column(name = "date_time")
    private LocalDate dateTime;
    @Column(name = "home_team_win_bet_rate")
    private Double homeTeamWinBetRate;
    @Column(name = "away_team_win_bet_rate")
    private Double awayTeamWinBetRate;
    @Column(name = "draw_game_bet_rate")
    private Double drawGameBetRate;
    @OneToOne
    @JoinColumn(name = "round_id")
    private Round round;
    @OneToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    public Game() {}
}
