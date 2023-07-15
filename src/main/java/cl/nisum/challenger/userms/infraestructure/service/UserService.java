package cl.nisum.challenger.userms.infraestructure.service;

import cl.nisum.challenger.userms.api.model.request.UserRequest;
import cl.nisum.challenger.userms.api.model.response.UserResponse;
import cl.nisum.challenger.userms.domain.entity.PhoneEntity;
import cl.nisum.challenger.userms.domain.entity.UserEntity;
import cl.nisum.challenger.userms.domain.repository.UserRepository;
import cl.nisum.challenger.userms.infraestructure.abstract_service.IUserService;
import cl.nisum.challenger.userms.util.JwtUtil;
import cl.nisum.challenger.userms.util.exception.IdNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author pradatech
 */
@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional
    @Override
    public UserResponse create(UserRequest request) {

        List<PhoneEntity> phones = request.getPhones().stream().map(phoneRequest -> {
            PhoneEntity phoneEntity = PhoneEntity.builder().build();
            return phoneEntity;
        }).toList();
        Set<PhoneEntity> phoneEntities = new HashSet<>(phones);
        UserEntity instance = UserEntity.builder().email(request.getEmail()).name(request.getName())
                .password(request.getPassword()).isActive(true).build();
        instance.setPhones(phoneEntities);

        UserEntity response = userRepository.save(instance);
        JwtUtil jwtToken = buildTokenJWT(response);
        response.setLastLogin(response.getCreatedDate());
        response.setToken(jwtToken.toString());
        return this.toResponse(response);
    }



    @Override
    public UserResponse read(UUID uuid) {
        return toResponse(this.userRepository.findById(uuid).orElseThrow(() -> new IdNotFoundException()));
    }


    private UserResponse toResponse(UserEntity entity) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(entity, userResponse);
        return userResponse;
    }

    private static JwtUtil buildTokenJWT(UserEntity response) {
        LocalDateTime ldt = LocalDateTime.now().plusDays(90);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(ldt, ZoneId.systemDefault());
        long date = zonedDateTime.toInstant().toEpochMilli();
        JwtUtil jwtToken = new JwtUtil(response.getName(), response.getEmail(),date);
        return jwtToken;
    }
}
