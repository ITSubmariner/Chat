package com.pet.chat.domain.requestParams;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RemoveGroupParameters {
    private long groupId;
    private long userId;
}
