// Old (broken)
String token = authentication; // ERROR

// Fixed
String token = tokenProvider.generateToken(authentication.getName());
