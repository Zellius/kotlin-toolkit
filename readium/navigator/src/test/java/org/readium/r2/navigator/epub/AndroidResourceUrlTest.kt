/*
 * Copyright 2026 Readium Foundation. All rights reserved.
 * Use of this source code is governed by the BSD-style license
 * available in the top-level LICENSE file of the project.
 */

package org.readium.r2.navigator.epub

import kotlin.test.assertEquals
import kotlin.test.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.readium.r2.navigator.R
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class AndroidResourceUrlTest {

    @Test
    fun `Create a URL for an Android file resource`() {
        val resources = RuntimeEnvironment.getApplication().resources

        assertEquals(
            EpubNavigatorFragment.assetUrl(
                EpubNavigatorFragment.androidResourcePath("drawable/readium_media_notification_fastforward.xml")
            ),
            EpubNavigatorFragment.androidResourceUrl(
                resources,
                R.drawable.readium_media_notification_fastforward
            )
        )
    }

    @Test
    fun `Return null for an unknown resource`() {
        val resources = RuntimeEnvironment.getApplication().resources

        assertNull(EpubNavigatorFragment.androidResourceUrl(resources, 0))
    }
}
