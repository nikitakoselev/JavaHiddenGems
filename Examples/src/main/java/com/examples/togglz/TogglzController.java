package com.examples.togglz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import static com.examples.togglz.TogglzFeatures.ALMOST_READY;
import static com.examples.togglz.TogglzFeatures.AWESOME;

// http://localhost:8080/actuator/togglz
// http://localhost:8080/togglz
@RestController
public class TogglzController {
    private FeatureManager featureManager;

    public TogglzController(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    @GetMapping("feature1")
    public String feature1() {
        return "Standard old stuff";
    }

    @GetMapping("awesome")
    public String awesome() {
        if (featureManager.isActive(AWESOME)) {
            return "Newest coolest feature";
        } else {
            return "";
        }
    }

    @GetMapping("almostready")
    public String almostready() {
        if (featureManager.isActive(ALMOST_READY)) {
            return "Newest coolest feature";
        } else {
            return "";
        }
    }
}
