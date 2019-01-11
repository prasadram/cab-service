package org.letuslearn.cabs.restservice.dto;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class CabsDto {

  @Valid
  private List<CabDto> data;
}
