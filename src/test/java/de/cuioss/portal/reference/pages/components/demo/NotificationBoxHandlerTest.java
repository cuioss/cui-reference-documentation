package de.cuioss.portal.reference.pages.components.demo;

import jakarta.inject.Inject;

import de.cuioss.portal.ui.test.junit5.EnablePortalUiEnvironment;
import de.cuioss.portal.ui.test.tests.AbstractPageBeanTest;
import lombok.Getter;

@EnablePortalUiEnvironment
class NotificationBoxHandlerTest extends AbstractPageBeanTest<NotificationBoxHandler> {

    @Inject
    @Getter
    private NotificationBoxHandler underTest;
}
