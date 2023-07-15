package cl.nisum.challenger.userms.infraestructure.abstract_service;

import cl.nisum.challenger.userms.api.model.request.UserRequest;
import cl.nisum.challenger.userms.api.model.response.UserResponse;


import java.util.UUID;
import java.util.List;

/**
 * @author pradatech
 */
public interface IUserService extends CrudService<UserRequest, UserResponse, UUID> {

    List<UserResponse> findAll();
}
