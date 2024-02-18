package com.cleancoders.hackacode.utils.adapter.out.persistence;

import java.util.Optional;

public interface OptionalChecker<O, E> {
    O check(Optional<O> optional);
}
