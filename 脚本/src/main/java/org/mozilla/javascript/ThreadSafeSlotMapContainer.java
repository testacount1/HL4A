/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.javascript;

import java.util.Iterator;
import org.mozilla.javascript.ScriptableObject.Slot;
import org.mozilla.javascript.ScriptableObject.SlotAccess;

/**
 * This class extends the SlotMapContainer so that we have thread-safe access to all
 * the properties of an object.
 */
class ThreadSafeSlotMapContainer
  extends SlotMapContainer {

  
  ThreadSafeSlotMapContainer(int initialSize)
  {
    super(initialSize);
  }

}
