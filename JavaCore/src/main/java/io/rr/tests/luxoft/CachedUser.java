package io.rr.tests.luxoft;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public final class CachedUser {
    private int id;

    private LocalDateTime added;

    private User user;

}
