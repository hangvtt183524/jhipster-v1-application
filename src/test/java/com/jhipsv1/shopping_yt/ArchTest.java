package com.jhipsv1.shopping_yt;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.jhipsv1.shopping_yt");

        noClasses()
            .that()
            .resideInAnyPackage("com.jhipsv1.shopping_yt.service..")
            .or()
            .resideInAnyPackage("com.jhipsv1.shopping_yt.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.jhipsv1.shopping_yt.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
