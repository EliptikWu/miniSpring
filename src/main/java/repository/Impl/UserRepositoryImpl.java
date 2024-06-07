package repository.Impl;


import domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import repository.UserRepository;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUser(){
        String query = "FROM user";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeUser(Long id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void addUser(User user){
        entityManager.merge(user);
    }

}