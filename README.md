# javaJWTToken

**JWT Authentication & Authorization:**
---------------------------------------

JWTs or JSON Web Tokens are most commonly used to identify an authenticated user. They are issued by an authentication server and are consumed by the client-server 
(to secure its APIs).

What is a JWT? 
JSON Web Token is an open industry standard used to share information between two entities, usually a client (like your app’s frontend) and a server (your app’s backend). 
They contain JSON objects which have the information that needs to be shared. Each JWT is also signed using cryptography (hashing) to ensure that the JSON 
contents (also known as JWT claims) cannot be altered by the client or a malicious party.

A token is a string that contains some information that can be verified securely. 
It could be a random set of alphanumeric characters which point to an ID in the database, or it could be an encoded JSON that can be self-verified by the client 
(known as JWTs).

**Structure of a JWT:**
A JWT contains three parts:
•	Header: Consists of two parts:
      o	The signing algorithm that’s being used.
      o	The type of token, which, in this case, is mostly “JWT”.
•	Payload: The payload contains the claims or the JSON object of clients.
•	Signature: A string that is generated via a cryptographic algorithm that can be used to verify the integrity of the JSON payload.

        In general, whenever we generated a token with JWT, the token is generated in the format of  <header>.<payload>.<signature>  in side JWT.
        
**Example: **

eyJhbGciOiJIUzUxMiJ9.
eyJzdWIiOiJkaWxpcEBnbWFpbC5jb20iLCJleHAiOjE2ODk1MjI5OTcsImlhdCI6MTY4OTUyMjY5N30.
bjFnipeNqiZ5dyrXZHk0qTPciChw0Z0eNoX5fu5uAmj6SE9mLIGD4Ll_3QeGfXjZqvv8KlJe2pmTseT4g8ZSIA


The following image shows details of the Encoded Token. 

![image](https://github.com/tek-teacher/javaJWTToken/assets/136072053/fe2dc04a-9ab4-4d53-98d6-7adf12f0bc8b)


**Follow us on:**
      https://www.instagram.com/tek.teacher/
