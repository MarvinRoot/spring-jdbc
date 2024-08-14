package com.spring.jdbc.hoxtify.model.filter;

import static com.spring.jdbc.hoxtify.model.constants.ConstantsEnum.ENTITY_MINUS_ONE;

abstract class Filter {
    protected long entityId = ENTITY_MINUS_ONE;

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public boolean hasEntityId() {
        return entityId != -1;
    }

    public Filter() {
    }

    public Filter(long entityId) {
        this.entityId = entityId;
    }
}
