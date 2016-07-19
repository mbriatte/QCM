package main.java.com.mika.jwt;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


import java.security.Key;
import java.security.SecureRandom;

import io.jsonwebtoken.*;

import java.util.Base64;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.util.Date;


//"https://libraries.io/github/robertjd/jjwt"

public class JwtGenerator {
	
	private static String NORMALKEY="eyJraWQiOiJub3JtYWwiLCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNDY4MjMxOTAyLCJzdWIiOiJhY2NlcyIsImlzcyI6Iklzc3VlcjEiLCJhdWQiOiJRQ00iLCJwYXlsb2FkIjoidGhpcyBpcyBhIHBheWxvYWQiLCJleHAiOjE0NjgyMzI5MDJ9.SgfDSx-aQNr7S_baqKLJJdmPoL9FVOpHtWouVAW3l90";
	private static String SPECIALKEY="eyJraWQiOiJzcGVjaWFsIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiIyIiwiaWF0IjoxNDY4MjMxOTAyLCJzdWIiOiJhY2Nlc3MiLCJpc3MiOiJJc3N1ZXIyIiwiYXVkIjoiUUNNIiwicGF5bG9hZCI6InRoaXMgaXMgYSBwYXlsb2FkIiwiZXhwIjoxNDY4MjMyOTAyfQ.JS3jQnoSa6yNrO5dnSrKbz3JIIrKgQ77xdY-oFyyQc0";

	
	public static String createJWT(String id, String issuer, String subject, long ttlMillis, Boolean withSpecialKey) {
		 
		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		 
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		byte[] apiKeySecretBytes=null;
		
		//We will sign our JWT with our ApiKey secret		
		String type_kid="";
		if (withSpecialKey) // pour certain on va utiliser une clef special
		{
			apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Base64.getEncoder().encodeToString(JwtGenerator.SPECIALKEY.getBytes()));
			type_kid="VIP";
		}
		else  // tout les autres auront une clef "normal"
			{
			apiKeySecretBytes = DatatypeConverter.parseBase64Binary(generateKey());
			type_kid="NORMAL";
			}
		
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		 
		  //Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id) // l'id du jeton -- unique de preference
		                                .setIssuedAt(now) // est valable  à partir de 
		                                .setSubject(subject)// le sujet poru lequel il est generé
		                                .setIssuer(issuer) // celui qu'il l'emet
		                                .setAudience("QCM") // a qui il est destiné
		                                .setHeaderParam("kid", type_kid) // l'indice poru savoir quelle clef utilisée pour le chiffrement
		                                .claim("payload","this is a payload") // le payload eventuelle
		                                .signWith(signatureAlgorithm, signingKey); // la signature
		 

		builder.setHeaderParam("typ", new String("JWT")); // le type de jeton
		 //if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
		    long expMillis = nowMillis + ttlMillis;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp);
		}
		
		 //Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
		}
	
	public static String generateKey()
	{
		return Base64.getEncoder().encodeToString(JwtGenerator.NORMALKEY.getBytes());
	}
	
	
	public static Claims  parseJWTwithKey(String jwt) {
		//This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parser()         
		   .setSigningKey(DatatypeConverter.parseBase64Binary(generateKey()))
		   .parseClaimsJws(jwt).getBody();
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
		System.out.println("payload: " + claims.get("payload", String.class));
		return claims;
	}
	
	public static Claims  parseJWTwithKeyhintinKeyID(String jwt) {
		//This line will throw an exception if it is not a signed JWS (as expected)
		SigningKeyResolver resolver = new SigningKeyResolverAdapter();
		 
		// attention c'est space !!!,
		//on va definir inline la classe SigningKeyResolverAdapter
		//qui va permettre dynamiquement de charger la clef de chiffrment en foocntion de la valeur du keyid
		Claims claims = Jwts.parser().setSigningKeyResolver(new SigningKeyResolverAdapter() {
	        @Override
	        public byte[] resolveSigningKeyBytes(JwsHeader header, Claims claims) {
	            //inspect the header or claims, lookup and return the signing key
	            String keyId = header.getKeyId(); //or any other field that you need to inspect
	            
	            if (keyId.equals("VIP")) 
	            {
		            return DatatypeConverter.parseBase64Binary(Base64.getEncoder().encodeToString(JwtGenerator.SPECIALKEY.getBytes()));

	            }
	            else 
	            {
	            	return DatatypeConverter.parseBase64Binary(generateKey());
	            }
	        }}).parseClaimsJws(jwt).getBody();
		
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
	
		return claims;
	}
	

}
