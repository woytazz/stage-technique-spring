package pl.technique.stage.util.hash;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Formatter;

@Component
public class HashGeneratorImpl implements HashGenerator {
    private final String SECRET_KEY = "Al-BNmoM80nHDaE2rCMlFAzRxXJtvRC6jzblTKr1vOc";

    private final String HMAC_SHA256 = "HmacSHA256";

    @SneakyThrows
    @Override
    public String generateHash(String input) {
        return toHexString(
                MessageDigest
                        .getInstance("SHA-256")
                        .digest(input.getBytes(StandardCharsets.UTF_8))
        );
    }

    @SneakyThrows
    @Override
    public String generateHMAC(String login, long version) {
        String data = login + version;

        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);

        return toHexString(mac.doFinal(data.getBytes()));
    }

    @SneakyThrows
    @Override
    public String generateHMAC(long id, long version) {
        String data = String.valueOf(id) + version;

        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(secretKeySpec);

        return toHexString(mac.doFinal(data.getBytes()));
    }

    private String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
}
