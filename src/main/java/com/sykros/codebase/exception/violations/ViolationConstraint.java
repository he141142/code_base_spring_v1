package com.sykros.codebase.exception.violations;

import java.util.ArrayList;
import java.util.List;

public class ViolationConstraint {
    List<ViolationEntity> violations = new ArrayList<>();

    public void addViolation(ViolationEntity violation) {
        this.violations.add(violation);
    }

    public ViolationEntity getViolationByFieldName(String name) {
        return this.violations.stream().filter(violation -> violation.getFieldName().equalsIgnoreCase(name))
                .findAny().orElse(null);
    }
}
