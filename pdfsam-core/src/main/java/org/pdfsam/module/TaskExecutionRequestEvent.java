/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 21/nov/2012
 * Copyright 2012 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.module;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.pdfsam.support.RequireUtils.require;
import static org.pdfsam.support.RequireUtils.requireNotNull;

import org.sejda.model.parameter.base.TaskParameters;

/**
 * Event sent to request a parameters execution.
 * 
 * @author Andrea Vacondio
 * 
 */
public class TaskExecutionRequestEvent {

    private TaskParameters parameters;
    private String moduleId;

    /**
     * @param moduleId
     *            the module requiring the task
     * @param parameters
     */
    public TaskExecutionRequestEvent(String moduleId, TaskParameters parameters) {
        requireNotNull(parameters, "Task parameters cannot be null");
        require(isNotBlank(moduleId), "Module id cannot be blank");
        this.parameters = parameters;
        this.moduleId = moduleId;
    }

    public TaskParameters getParameters() {
        return parameters;
    }

    public String getModuleId() {
        return moduleId;
    }

}