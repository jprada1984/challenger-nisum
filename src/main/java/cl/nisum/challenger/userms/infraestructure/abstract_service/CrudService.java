package cl.nisum.challenger.userms.infraestructure.abstract_service;

/**
 * @author pradatech
 * @param <RQ> Request Dto
 * @param <RS> Response Dto
 * @param <ID> Identifier of entity
 */
public interface CrudService<RQ, RS, ID>{

    RS create(RQ request);
    RS read(ID id);
}