package com.javanauta.agenda_tarefa.business;

import com.javanauta.agenda_tarefa.business.converter.UsuarioConverter;
import com.javanauta.agenda_tarefa.business.dto.UsuarioDTO;
import com.javanauta.agenda_tarefa.infrastructure.entity.Usuario;
import com.javanauta.agenda_tarefa.infrastructure.exceptions.ConflictException;
import com.javanauta.agenda_tarefa.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter  usuarioConverter;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {

        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));

        Usuario usuarioEntity = usuarioConverter.paraUsuario(usuarioDTO);

        return usuarioConverter.paraUsuarioDTO(usuarioEntity = usuarioRepository.save(usuarioEntity));
    }

    public void emailExiste(String email) {
        try {
            boolean existe = verificaEmail(email);
            if (existe) {
                throw new ConflictException("Email ja cadastrado " + email);
            }
        } catch (ConflictException e) {
            throw new ConflictException("Email ja cadastrado " + e.getCause());
        }
    }

    public boolean verificaEmail(String email) {

        return usuarioRepository.existsByEmail(email);
    }

}
