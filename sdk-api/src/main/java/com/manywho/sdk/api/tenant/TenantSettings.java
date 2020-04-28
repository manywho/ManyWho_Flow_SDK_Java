package com.manywho.sdk.api.tenant;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class TenantSettings {
    private String formatValues;
    private ReleaseCycle releaseCycle;

    public enum ReleaseCycle {
        Monthly("monthly"),
        Rolling("rolling");

        private final String cycle;

        ReleaseCycle(String cycle) {
            this.cycle = cycle;
        }

        @JsonCreator
        public static ReleaseCycle forValue(String value) {
            for (ReleaseCycle releaseCycle : values()) {
                if (value.equalsIgnoreCase(releaseCycle.cycle)) {
                    return releaseCycle;
                }
            }

            throw new IllegalArgumentException("No release cycle with text " + value + " found");
        }

        @Override
        public String toString() {
            return cycle;
        }
    }
}
