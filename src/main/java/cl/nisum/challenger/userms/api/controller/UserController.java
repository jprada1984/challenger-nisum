package cl.nisum.challenger.userms.api.controller;

import cl.nisum.challenger.userms.api.model.request.UserRequest;
import cl.nisum.challenger.userms.api.model.response.UserResponse;
import cl.nisum.challenger.userms.infraestructure.abstract_service.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request) {
        UserResponse response= userService.create(request);
        return ResponseEntity.created(URI.create("/api/user/"+response.getId().toString())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.read(id));
    }


}
