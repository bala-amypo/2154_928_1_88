// Old (broken)
String email = tokenProvider.getEmailFromToken(token);

// Fixed
String username = tokenProvider.getUsernameFromJWT(token);
