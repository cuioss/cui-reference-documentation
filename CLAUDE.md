# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A Quarkus-based JSF web application serving as the **CUI Portal Reference Documentation**. It showcases CUI JSF components, Portal UI features, PrimeFaces integrations, and Bootstrap elements as interactive, browsable documentation pages.

## Build & Development Commands

```bash
# Build and run tests
./mvnw verify

./mvnw clean install -Ppre-commit

# Run locally in dev mode (hot-reload)
./mvnw quarkus:dev

# Run a single test class
./mvnw test -Dtest=ConfigDocuBeanTest

# Run a single test method
./mvnw test -Dtest=ConfigDocuBeanTest#testMethod

# Build without tests
./mvnw package -DskipTests
```

CI builds against Java 17, 21, and 23 using `./mvnw verify`.

## Architecture

### Technology Stack
- **Runtime**: Quarkus with MyFaces (JSF/Faces) via `myfaces-quarkus` extension
- **UI Framework**: CUI JSF components (`cui-jsf-bootstrap`, `cui-jsf-core-components`) + PrimeFaces (Jakarta classifier)
- **Portal Framework**: CUI Portal UI (`portal-ui-quarkus-extension`) and Portal Core for configuration, authentication, navigation, templating
- **CDI**: Jakarta CDI with Quarkus Arc (note: `quarkus.arc.unremovable-types=de.cuioss.portal.**` keeps portal beans)
- **Build**: Maven with `cui-parent-pom` (provides dependency versions, plugins, profiles)
- **Lombok**: Enabled with `@LombokGenerated` annotation for coverage exclusion

### Package Structure (`de.cuioss.portal.reference`)

- **`portal/`** — Portal integration layer:
  - `ReferenceTemplates` — Registers custom Facelets templates (`layout_portal_core.xhtml`, `layout_portal_labeledContainer.xhtml`)
  - `navigation/ReferenceMenuProvider` — `@SessionScoped` alternative that builds the full navigation menu hierarchy
  - `navigation/items/` — Individual menu item classes organized by section (bootstrap, cui, external, icon, portal, prime)
  - `application/ReferenceBundle` — Resource bundle registration

- **`pages/`** — Backing beans for documentation pages:
  - `components/demo/` — Demo backing beans for individual component showcases (dialogs, lazy loading, data tables, etc.)
  - `demo/` — General demo beans (address generator, graph demos)
  - `portal/` — Portal-specific page beans (bundle overview, template descriptors)
  - Icon overview beans (`CuiIconsOverviewPageBean`, `MimeTypeIconsPageBean`, `PrimeFacesIconsOverviewPageBean`)

### View Layer
- **Templates**: `src/main/resources/META-INF/templates/reference/` — Facelets layout templates
- **Pages**: `src/main/resources/META-INF/resources/documentation/` — XHTML pages organized by documentation section (portal, cui_components, icons, demo, external, prime, getting_started)
- **Config**: `src/main/resources/META-INF/microprofile-config.properties` — Portal navigation, authentication mock, and menu configuration

### Authentication
Uses `portal-authentication-mock` at runtime — always returns an authenticated user with `Master-Administrator` role. This is a documentation app, not a secured application.

## Conventions

- Backing beans use `@SessionScoped`, `@ViewScoped`, or `@Dependent` CDI scopes with Lombok (`@EqualsAndHashCode`, `@ToString`, `@Getter`)
- Navigation menu items implement `NavigationMenuItem`/`NavigationMenuItemContainer` from `cui-jsf-api`
- Portal priorities use `PortalPriorities.PORTAL_MODULE_LEVEL` for `@Priority` annotations
- Tests extend CUI base test classes (e.g., `BaseModuleConsistencyTest` for CDI wiring consistency)
- 4-space indent, UTF-8, LF line endings (see `.editorconfig`)
