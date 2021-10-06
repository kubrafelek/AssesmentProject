package tapu.com.project.security;

public class SecurityConstants {

    public static final String SIGN_UP_URL = "/api/sign-up";
    public static final String LOGIN = "/api/login";
    public static final String SECRET = "Kodluyoruz";
    public static final long EXPIRATION_TIME = 432_000_000; // 5 gün
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
