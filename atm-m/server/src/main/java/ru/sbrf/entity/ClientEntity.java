package ru.sbrf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.sbrf.dto.AccountDto;
import ru.sbrf.model.Currency;

@Data
@Entity
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "CLIENT")
public class ClientEntity {

  @Id
  @SequenceGenerator(name = "S_CLIENT_GEN", sequenceName = "S_CLIENT", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CLIENT_GEN")
  @Column(name = "CLIENT_ID", unique = true, nullable = false)
  private Long id;

  @Column(name = "FIO", nullable = false, length = 1000)
  private String fio;
  @Column(name = "BALANCE", nullable = false, length = 10)
  private Long balance;
  @Column(name = "CURRENCY", nullable = false, length = 10)
  private String currency;

  public AccountDto toDto(){
    return AccountDto.builder()
        .id(this.id)
        .balance(this.balance)
        .currency(Currency.valueOf(this.currency))
        .build();
  }
}
