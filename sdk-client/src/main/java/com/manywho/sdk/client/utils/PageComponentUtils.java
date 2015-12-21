package com.manywho.sdk.client.utils;

import com.manywho.sdk.client.entities.PageComponent;
import com.manywho.sdk.entities.run.elements.ui.PageComponentDataResponse;
import com.manywho.sdk.entities.run.elements.ui.PageComponentResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PageComponentUtils {
    private static List<String> inputTypes = Collections.singletonList("INPUT");

    public static PageComponent createPageComponent(PageComponentResponse componentResponse, List<PageComponentDataResponse> componentDataResponses) {
        PageComponent pageComponent = new PageComponent();
        pageComponent.setAttributes(componentResponse.getAttributes());
        pageComponent.setContentType(componentResponse.getContentType());
        pageComponent.setId(componentResponse.getId());
        pageComponent.setName(componentResponse.getDeveloperName());
        pageComponent.setOrder(componentResponse.getOrder());
        pageComponent.setType(componentResponse.getComponentType());

        // See if there is a corresponding PageComponentDataResponse for the current component
        Optional<PageComponentDataResponse> componentData = componentDataResponses.stream()
                .filter(componentDataResponse -> componentDataResponse.getPageComponentId().equals(componentResponse.getId()))
                .findFirst();

        if (componentData.isPresent()) {
            PageComponentDataResponse componentDataResponse = componentData.get();

            PageComponent.Data pageComponentData = new PageComponent.Data()
                    .setContent(componentDataResponse.getContent())
                    .setContentValue(componentDataResponse.getContentValue())
                    .setEditable(componentDataResponse.isEditable())
                    .setEnabled(componentDataResponse.isEnabled())
                    .setFileDataRequest(componentDataResponse.getFileDataRequest())
                    .setObjectData(componentDataResponse.getObjectData())
                    .setObjectDataRequest(componentDataResponse.getObjectDataRequest())
                    .setRequired(componentDataResponse.isRequired())
                    .setVisible(componentDataResponse.isVisible());

            pageComponent.setData(pageComponentData);
        }

        return pageComponent;
    }

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
