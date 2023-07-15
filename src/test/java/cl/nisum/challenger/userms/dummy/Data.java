package cl.nisum.challenger.userms.dummy;

import cl.nisum.challenger.userms.api.model.response.UserResponse;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class Data {

    public static final Optional<UserResponse> createUser001(){
        return Optional.of(new UserResponse(
                UUID.fromString("d196c1ac-e03d-4ffe-8bf6-9e98a0e5c41a"),
                LocalDateTime.parse("2023-07-14 16:47:38.421083"),
                LocalDateTime.parse("2023-07-14 16:47:38.511104"),
                LocalDateTime.parse("2023-07-14 16:47:38.421083"),
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKaW1teSIsImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNjk3MTQ3MjU4NDY1LCJpYXQiOjE2ODkzNTMyNTgsImp0aSI6IjEzOTVkZjY2LWRhMDAtNGU1NS1iOWE0LTg3NGEwMTM5NmUyMiJ9.-avBewmgAdX6YlQSjyJ50Sgm6M_3-nR6wdg8d6OEohw",
                true)
        );
    }

    public static final Optional<UserResponse> createUser002(){
        return Optional.of(new UserResponse(
                UUID.fromString("37c7dcca-6260-4190-8792-7f1e41d756cb"),
                LocalDateTime.parse("2023-07-14 16:47:38.421083"),
                LocalDateTime.parse("2023-07-14 16:47:38.511104"),
                LocalDateTime.parse("2023-07-14 16:47:38.421083"),
                "eyJzdWIiOiJBbml0YSIsImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNjk3MTQ5NTk4MDg2LCJpYXQiOjE2ODkzNTU1OTgsImp0aSI6IjQ3ODYzOTczLWI4MmYtNDVhNy1iMjU1LTNlYjRmNTExNDA3ZCJ9.3CjItdPVMS5duF3LMvbeZGTHo2vff6froxB06I-B0GE",
                true)
        );
    }
}
