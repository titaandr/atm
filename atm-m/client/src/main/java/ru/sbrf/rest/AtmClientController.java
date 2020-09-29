package ru.sbrf.rest;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.dto.ClientDto;
import ru.sbrf.service.AtmClientService;
import org.springframework.http.HttpEntity;
@RestController
@AllArgsConstructor
public class AtmClientController {

  private final AtmClientService atmClientService;

  @GetMapping("/atm/{atmId}/client/{clientId}")
  public ResponseEntity<ClientDto> getClientBalance(@PathVariable Long atmId, @PathVariable Long clientId) {
    ClientDto clientInfo = atmClientService.getClientInfo(atmId, clientId);

    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<Request> request = new HttpEntity<>(new Request(1, "{\"clientId\":"+ clientId, RequestTypes.JSON));
    restTemplate.postForEntity("http://127.0.0.1:5555/atm/server/client/" + clientId, request, String.class);

    return ResponseEntity.ok().body(clientInfo);
  }
}
