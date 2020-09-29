package ru.sbrf.repository;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.entity.ClientEntity;

@Repository
public interface AccountRepository extends CrudRepository<ClientEntity, Long> {

  @Override
  Optional<ClientEntity> findById(Long aLong);
}