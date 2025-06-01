import emil.komp.asteroids.common.services.IScore;

module ScoreingClient {
    requires spring.web;
    exports emil.komp.asteroids.ScoreingClient;
    requires Common;
    provides IScore with emil.komp.asteroids.ScoreingClient.ScoreingClient;
}