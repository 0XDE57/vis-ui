/*
 * Copyright 2014-2015 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kotcrab.vis.editor.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.editor.module.editor.MenuBarModule;
import com.kotcrab.vis.editor.ui.scene.SceneTab;

/**
 * {@link MenuBarModule} MenuItem controller that automatically enables/disables item when current active tab is {@link SceneTab} or not
 * @author Kotcrab
 */
public class SceneStatusWidgetController {
	private Array<Button> buttons;
	private boolean loaded = false;

	public SceneStatusWidgetController () {
		buttons = new Array<>();
	}

	public void setSceneTabActive (boolean active) {
		loaded = active;
		updateWidgets();
	}

	private void updateWidgets () {
		for (Button b : buttons)
			b.setDisabled(!loaded);
	}

	public void addButton (Button button) {
		buttons.add(button);
		button.setDisabled(!loaded);
	}

	public boolean removeButton (Button button) {
		return buttons.removeValue(button, true);
	}
}
