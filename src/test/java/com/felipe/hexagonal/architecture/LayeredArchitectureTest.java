package com.felipe.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.boot.test.context.SpringBootTest;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.felipe.hexagonal")
@SpringBootTest
public class LayeredArchitectureTest {

    @ArchTest
    public static final ArchRule layered_architecture_test = layeredArchitecture()
            .consideringAllDependencies()
            .layer("AdaptersIn").definedBy("..adapters.in..")
            .layer("AdaptersOut").definedBy("..adapters.out..")
            .layer("UseCase").definedBy("..application.core.usecase..")
            .layer("PortsIn").definedBy("..application.ports.in..")
            .layer("PortsOut").definedBy("..application.ports.out..")
            .layer("Config").definedBy("..config..")
            .whereLayer("UseCase").mayOnlyAccessLayers("config")
            .whereLayer("PortsIn").mayOnlyAccessLayers("UseCase", "AdaptersIn")
            .whereLayer("PortsOut").mayOnlyAccessLayers("UseCase", "AdaptersOut")
            .whereLayer("Config").mayNotAccessAnyLayer();
}
