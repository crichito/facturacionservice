package app.erp.dao.espec;

import java.util.List;

/*
 * @Autor: Cristhian Huangal
 * @Fecha: 06/02/2016
 * @Motivo: Interface general con metodos de mantenimiento CRUD
 */

public interface CRUDService<T> {
	List<T> listAll(String keyAuth);

    T getById(String key, String keyAuth);

    T Save(T domainObject, String keyAuth);
    
    T Update(T domainObject, String keyAuth);

    void delete(String key, String keyAuth);
}
