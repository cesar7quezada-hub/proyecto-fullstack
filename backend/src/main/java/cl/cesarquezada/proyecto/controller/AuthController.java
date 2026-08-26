package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.LoginRequest;
import cl.cesarquezada.proyecto.dto.LoginResponse;
import cl.cesarquezada.proyecto.entity.Usuario;
import cl.cesarquezada.proyecto.entity.UsuarioRol;
import cl.cesarquezada.proyecto.repository.UsuarioRepository;
import cl.cesarquezada.proyecto.repository.UsuarioRolRepository;
import cl.cesarquezada.proyecto.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UsuarioRepository usuarioRepository,
            UsuarioRolRepository usuarioRolRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<String> roles = usuarioRolRepository.findByUsuarioIdAndActivoTrue(usuario.getId())
                .stream()
                .map(usuarioRol -> usuarioRol.getRol().getCodigo())
                .toList();

        String token = jwtService.generateToken(request.getUsername(), roles);
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
