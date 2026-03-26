package edu.icet.controller;

import edu.icet.model.dto.AuthRequest;
import edu.icet.model.dto.AuthResponse;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                String token = jwtUtil.generateToken(user.getEmail());

                return ResponseEntity.ok(new AuthResponse(token, user.getRole().name()));
            }
        }
        return ResponseEntity.status(401).body("Invalid email or password!");
    }
}