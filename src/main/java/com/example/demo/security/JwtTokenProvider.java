@Component
public class JwtTokenProvider {

    private String jwtSecret;
    private long jwtExpirationMs;

    // No-arg constructor for Spring
    public JwtTokenProvider() {
        this.jwtSecret = "MySuperSecretJwtKeyForApartmentSystem123456";
        this.jwtExpirationMs = 3600000L;
    }

    // Constructor to match your test
    public JwtTokenProvider(String jwtSecret, long jwtExpirationMs) {
        this.jwtSecret = jwtSecret;
        this.jwtExpirationMs = jwtExpirationMs;
    }

    // --- rest of the code remains same ---
}
