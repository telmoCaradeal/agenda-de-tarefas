package com.javanauta.agenda_tarefa.controller;


import com.javanauta.agenda_tarefa.business.UsuarioService;
import com.javanauta.agenda_tarefa.business.dto.UsuarioDTO;
import com.javanauta.agenda_tarefa.infrastructure.entity.Usuario;
import com.javanauta.agenda_tarefa.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));

    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha())
        );
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity <Usuario> consultaUsuario(@RequestParam("email") String email){
        return ResponseEntity.ok(usuarioService.consultarUsuarioEmail(email));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> excluirUsuarioEmail(@PathVariable String email){
        usuarioService.excluirUsuarioEmail(email);
        return ResponseEntity.ok().build();
    }
}
