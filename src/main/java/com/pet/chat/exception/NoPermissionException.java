package com.pet.chat.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
@NoArgsConstructor
public class NoPermissionException extends RuntimeException {
}
