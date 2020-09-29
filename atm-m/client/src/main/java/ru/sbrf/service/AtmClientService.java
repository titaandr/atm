package ru.sbrf.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.sbrf.dto.ClientDto;

@Log
@Service
@AllArgsConstructor
public class AtmClientService {

  public ClientDto getClientInfo(Long atmId, Long clientId) {
    return new ClientDto("123");
  }
}
