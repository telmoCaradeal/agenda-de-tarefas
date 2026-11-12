package com.javanauta.agenda_tarefa.business;

import com.javanauta.agenda_tarefa.business.converter.UsuarioConverter;
import com.javanauta.agenda_tarefa.business.dto.UsuarioDTO;
import com.javanauta.agenda_tarefa.infrastructure.entity.Usuario;
import com.javanauta.agenda_tarefa.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter  usuarioConverter;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioEntity = usuarioConverter.paraUsuario(usuarioDTO);

        return usuarioConverter.paraUsuarioDTO(usuarioEntity = usuarioRepository.save(usuarioEntity));
    }
}
