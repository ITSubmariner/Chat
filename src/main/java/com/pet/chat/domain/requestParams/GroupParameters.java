package com.pet.chat.domain.requestParams;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupParameters {
    private String name;
    private long adminId;
}
