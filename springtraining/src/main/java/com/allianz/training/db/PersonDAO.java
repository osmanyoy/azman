package com.allianz.training.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.allianz.training.Person;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long>  {
	List<Person> findByName(String name);
	List<Person> findByNameAndSurnameOrderByName(String name,String surname);
	List<Person> findBySurnameIn(List<String> surname);
	
	@Query(value="select p from Person p where p.name= :nm")
	List<Person> findByCustom(@Param("nm") String name);
	
	@Query(value="select * from person where name= :nm" ,nativeQuery=true)
	List<Person> findByCustomNative(@Param("nm") String name);
	
	List<Person> test(@Param("name") String name);
	
    @Query(value="select * from person p , xyz pa where p.personcredentialid = pa.pc_id and pa.help= :username" ,nativeQuery=true)
    List<Person> findCustomUsernameNative(@Param("username") String username);
	
	

}
