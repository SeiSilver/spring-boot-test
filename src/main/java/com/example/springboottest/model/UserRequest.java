package com.example.springboottest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

  @NotEmpty(message = "Username must not empty!")
  @Length(min = 6, max = 64, message = "length must greater than 6 and smaller than 64")
  private String username;

  @NotEmpty(message = "First Name must not empty!")
  @Length(max = 64, message = "length must smaller than 64")
  private String firstName;

  @NotEmpty(message = "Last Name must not empty!")
  @Length(max = 64, message = "length must smaller than 64")
  private String lastName;

  @NotNull(message = "birth must not empty!")
  @JsonFormat(pattern="dd-MM-yyyy")
  private Timestamp birth;

}

