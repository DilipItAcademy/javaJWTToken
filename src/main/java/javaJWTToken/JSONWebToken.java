package javaJWTToken;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//JWT TOKEn Generation
public class JSONWebToken {

	static String key = "ZOMATO";

	public static void main(String ar[]) {

		// Creating/Producing Tokens
		String token = Jwts.builder().setId("dilipsingh1306@gmail.com").setSubject("To Access Address")
				.setIssuer("ZOMATO COMPANY").setIssuedAt(new Date(System.currentTimeMillis())) // Date +Time creation of
																								// token
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))
				.signWith(SignatureAlgorithm.HS256, key.getBytes()).compact();

		System.out.println(token);

		claimToken(token);

	}

	public static void claimToken(String token) {

		// Claims : claiming the token : Simply reading details from generated token by
		// passing secret
		Claims claim = (Claims) Jwts.parser().setSigningKey(key.getBytes()).parse(token).getBody();

		String userId = claim.getId();
		Date createdDateTime = claim.getIssuedAt();
		Date expDateTime = claim.getExpiration();
		String issuer = claim.getIssuer();
		String subject = claim.getSubject();

		System.out.println(userId);
		System.out.println(createdDateTime);
		System.out.println(expDateTime);
		System.out.println(issuer);
		System.out.println(subject);

		boolean isExpired = isTokenExpired(expDateTime);
		System.out.println("IS It Expired? " + isExpired);

	}

	public static boolean isTokenExpired(Date expTime) {

		return expTime.before(new Date(System.currentTimeMillis()));

	}

}
