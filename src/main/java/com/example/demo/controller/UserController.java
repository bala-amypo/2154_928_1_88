@PostMapping("/login")
public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
    User user = userService.login(request); // ensure login returns a User
    String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole());
    LoginResponse response = new LoginResponse(user.getId(), user.getEmail(), token);
    return ResponseEntity.ok(response);
}
