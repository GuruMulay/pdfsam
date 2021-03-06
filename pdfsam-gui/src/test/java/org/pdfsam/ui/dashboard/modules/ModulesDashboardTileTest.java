/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 28/ago/2014
 * Copyright 2017 by Sober Lemur S.a.s. di Vacondio Andrea (info@pdfsam.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.ui.dashboard.modules;

import static org.junit.Assert.assertEquals;
import static org.loadui.testfx.Assertions.verifyThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.sejda.eventstudio.StaticStudio.eventStudio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.categories.TestFX;
import org.mockito.ArgumentCaptor;
import org.pdfsam.test.ClearEventStudioRule;
import org.pdfsam.test.DefaultPriorityTestModule;
import org.pdfsam.ui.commons.SetActiveModuleRequest;
import org.sejda.eventstudio.Listener;

import javafx.scene.Parent;
import javafx.scene.input.MouseButton;

/**
 * @author Andrea Vacondio
 *
 */
@Category(TestFX.class)
public class ModulesDashboardTileTest extends GuiTest {

    @Rule
    public ClearEventStudioRule clearRule = new ClearEventStudioRule();

    @Override
    protected Parent getRootNode() {
        return new ModulesDashboardTile(new DefaultPriorityTestModule());
    }

    @Test
    public void activateOnClick() {
        Listener<SetActiveModuleRequest> listener = mock(Listener.class);
        eventStudio().add(SetActiveModuleRequest.class, listener);
        move(".dashboard-modules-invisible-button").press(MouseButton.PRIMARY);
        verifyThat(".dashboard-modules-tile", (ModulesDashboardTile v) -> v.isArmed());
        release(MouseButton.PRIMARY);
        ArgumentCaptor<SetActiveModuleRequest> captor = ArgumentCaptor.forClass(SetActiveModuleRequest.class);
        verify(listener).onEvent(captor.capture());
        assertEquals(DefaultPriorityTestModule.ID, captor.getValue().getActiveModuleId().get());
    }
}
