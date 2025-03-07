package javaJWTToken;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

//JWT TOKEn Generation
public class JSONWebToken {

		// Secret key
	private final String SECRET_KEY = "ThisIsSecretKeyUsedForEncryptionDecryptionOfData";
	private final long TOKEN_EXPIRY_DURATION = 5 * 60000; // 5 mins // 1sec = 1000 ms -> 1 min = 60000 ms

	public static void main(String[] args) {

		JWTUtil jwt = new JWTUtil();
		String token = jwt.createToken("dilipitacademy");
		System.out.println("Token Created For User : dilipitacademy : " + token);

		// Validation Of Token

		System.out.println("Getting User Name From Token ");
		String userName = jwt.getUserIdFromToken(token);
		System.out.println("User Name Retrived From Token : " + userName);

		System.out.println("Validation Of Token  : ");
		boolean isValid = jwt.isValidToken(token, "dilipitacademy");
		System.out.println("Is Token Valid ? " + isValid);

	}

	private SecretKey getSecretKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String createToken(String emailId) {

		String token = Jwts.builder()
				.subject(emailId) // unique user id
				.issuedAt(new Date(System.currentTimeMillis())) // setting creation time
				.expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRY_DURATION)) // setting Expire time
				.signWith(getSecretKey())
				.compact();

		return token;
	}

	public boolean isValidToken(String token, String userId) {
		String userIDFromToken = getUserIdFromToken(token);
		return userIDFromToken.equalsIgnoreCase(userId) && isTokenExpired(token);
	}

	// user Id from the token
	public String getUserIdFromToken(String token) {
		return Jwts.parser()
				.verifyWith(getSecretKey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}

	// check if the token has expired
	private boolean isTokenExpired(String token) {
		Date expirtyTime = Jwts.parser()
				.verifyWith(getSecretKey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getExpiration();
		System.out.println("Token Epirty Time : " + expirtyTime);
		return expirtyTime.after(new Date());
	}
}
