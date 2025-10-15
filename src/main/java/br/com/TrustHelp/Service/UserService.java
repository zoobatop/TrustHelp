package br.com.TrustHelp.Service;


import br.com.TrustHelp.Model.User;
import br.com.TrustHelp.Record.UserDTO;
import br.com.TrustHelp.Record.UserRequest;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
    public class UserService
    {
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final UserMapper userMapper;

        public List<UserDTO> listarTodos() {
            return userRepository.findAll() .stream() .map(userMapper::toDTO) .toList();
        }
        public UserDTO criar(UserRequest request) {
            if (!userRepository.existsByEmail(request.email())) {
                User user = userMapper.toEntity(request);
                user.setSenha(passwordEncoder.encode(request.senha()));
                return userMapper.toDTO(userRepository.save(user));
            } else {
                throw new BusinessException("Email já cadastrado");
            }
        }
    }
