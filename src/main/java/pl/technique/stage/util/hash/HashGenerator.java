package pl.technique.stage.util.hash;

public interface HashGenerator {
    String generateHash(String input);

    String generateHMAC(String login, long version);

    String generateHMAC(long id, long version);
}
