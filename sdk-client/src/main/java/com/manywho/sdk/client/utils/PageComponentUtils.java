package com.manywho.sdk.client.utils;

import com.manywho.sdk.client.entities.PageComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PageComponentUtils {
    private static List<String> inputTypes = Collections.singletonList("INPUT");

    public static boolean doInputComponentsExist(List<PageComponent> components, List<String> customTypes) {
        return components.stream()
                .anyMatch(component -> inputTypes.contains(component.getType()) || customTypes.contains(component.getType()));
    }

    public static boolean doInputComponentsExist(List<PageComponent> pageComponents) {
        return doInputComponentsExist(pageComponents, new ArrayList<>());
    }

    public static boolean doesComponentWithTypeExist(List<PageComponent> pageComponents, String type) {
        return pageComponents.stream()
                .anyMatch(component -> component.getType().equals(type));
    }

    public static Optional<PageComponent> getFirstComponentWithType(List<PageComponent> pageComponents, String type) {
        return pageComponents.stream()
                .filter(component -> component.getType().equals(type))
                .findFirst();
    }
}
