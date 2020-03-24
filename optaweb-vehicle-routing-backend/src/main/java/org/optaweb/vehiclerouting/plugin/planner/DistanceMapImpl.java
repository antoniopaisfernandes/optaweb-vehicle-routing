/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaweb.vehiclerouting.plugin.planner;

import java.util.Objects;

import org.optaweb.vehiclerouting.plugin.planner.domain.DistanceMap;
import org.optaweb.vehiclerouting.plugin.planner.domain.PlanningLocation;
import org.optaweb.vehiclerouting.service.location.DistanceMatrixRow;

/**
 * Temporary distance map implementation that allows to compute and store distances purely from
 * {@link org.optaweb.vehiclerouting.domain domain objects} and later be queried using Planning domain objects.
 */
// TODO get rid of dependency on Planning domain
public class DistanceMapImpl implements DistanceMap {

    private final DistanceMatrixRow distanceMatrixRow;

    public DistanceMapImpl(DistanceMatrixRow distanceMatrixRow) {
        this.distanceMatrixRow = Objects.requireNonNull(distanceMatrixRow);
    }

    @Override
    public long distanceTo(PlanningLocation location) {
        return distanceMatrixRow.distanceTo(location.getId()).millis();
    }
}
