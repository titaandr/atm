package ru.sbrf.service;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbrf.dto.AccountDto;
import ru.sbrf.entity.ClientEntity;
import ru.sbrf.repository.AccountRepository;

@Service
@AllArgsConstructor
public class AtmServerService {

  private final AccountRepository accountRepository;

  public AccountDto getClientInfo(Long clientId) {
    Optional<ClientEntity> byId = accountRepository.findById(clientId);
    if(byId.isPresent()){
      return byId.get().toDto();
    }
    throw new IllegalArgumentException();
  }

}
