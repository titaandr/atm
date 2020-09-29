package ru.sbrf.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import ru.sbrf.dto.AccountDto;
import ru.sbrf.service.AtmServerService;

@RestController
@AllArgsConstructor
public class AtmServerController {
  private final AtmServerService atmServerService;

  @GetMapping("/atm/server/{clientId}")
  public ResponseEntity<AccountDto> getClientBalance( @PathVariable Long clientId) {
    AccountDto AccountInfo = atmServerService.getClientInfo(clientId);
    return ResponseEntity.ok().body(AccountInfo);
  }
}
