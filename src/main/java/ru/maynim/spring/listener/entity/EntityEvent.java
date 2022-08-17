package ru.maynim.spring.listener.entity;

import java.util.EventObject;
import lombok.Getter;

public class EntityEvent extends EventObject {

    @Getter private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }
}
