package com.cegeka.switchfully.security.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public enum ArmyFeature {

    DEPLOY(ArmyRole.PRIVATE, ArmyRole.GENERAL),
    JOIN(ArmyRole.CIVILIAN),
    MANAGE_SOLDIER(ArmyRole.HUMAN_RELATIONSHIPS),
    NUKE(ArmyRole.GENERAL);

    private Collection<ArmyRole> roles = new ArrayList<>();

    ArmyFeature(ArmyRole... roles) {
        this.roles.addAll(stream(roles).collect(toList()));
    }

    public Collection<ArmyRole> getRoles() {
        return roles;
    }

    public static Collection<ArmyFeature> getFeaturesForRole(ArmyRole armyRole) {
        return Arrays.stream(values()).filter(f -> f.getRoles().contains(armyRole)).collect(toList());
    }
}
