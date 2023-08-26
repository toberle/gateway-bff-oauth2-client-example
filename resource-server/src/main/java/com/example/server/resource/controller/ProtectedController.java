package com.example.server.resource.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Protected resource content");
    }

    @PreAuthorize("hasRole('SCOPE_SUPER_ADMIN')")
    @GetMapping(path = "/super-protected")
    public ResponseEntity<String> getSuperProtected(Authentication authentication) {
        return ResponseEntity.ok("Super protected resource content");
    }

    @PreAuthorize("authentication.name == 'admin'")
    @GetMapping(path = "/admin-protected")
    public ResponseEntity<String> getAdminProtected(Authentication authentication) {
        return ResponseEntity.ok("Admin (username) protected resource content");
    }
}
