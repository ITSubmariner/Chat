package com.pet.chat.domain.requestParams;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserParameters {
    String username;
    String password;
}
