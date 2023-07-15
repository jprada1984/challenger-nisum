package cl.nisum.challenger.userms.domain.repository;

import cl.nisum.challenger.userms.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author pradatech
 */
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
