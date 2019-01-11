package com.acornejo.springDataDemo.Service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyDbRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {


    List<T> findAll();

    <S extends T> S save(S entity);


}
