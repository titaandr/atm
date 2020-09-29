package ru.sbrf.dto;

import lombok.Builder;
import ru.sbrf.model.Currency;

@Builder
public class AccountDto {
  private Long id;
  private long balance;
  private Currency currency;

}
