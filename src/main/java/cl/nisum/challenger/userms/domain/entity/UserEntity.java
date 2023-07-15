package cl.nisum.challenger.userms.domain.entity;

import cl.nisum.challenger.userms.domain.audit.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * @author pradatech
 */
@Entity
@Table(name="users")
@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AuditableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name", length = 150)
    private String name;
    @Column(name = "email", length = 300, unique = true)
    private String email;
    @Column(name = "password", length = 350)
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<PhoneEntity> phones;
    @Column(name = "token", length = 500)
    private String token;
    @Column(name = "last_login", columnDefinition = "timestamp")
    private LocalDateTime lastLogin;
    @Column(name = "is_active", columnDefinition = "boolean default TRUE")
    private Boolean isActive;
}
