/*
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.aperture.utils

import android.content.Context
import android.net.Uri
import android.os.Bundle

/**
 * Shows the self-timer on the Glyph Matrix of a Nothing Phone (3) (OpenGlyph), so the
 * countdown is visible when shooting with the rear camera. Does nothing elsewhere.
 */
object GlyphCountdown {
    private val uri = Uri.parse("content://org.openglyph.recordlight")

    /** Starts a countdown of [seconds] on the matrix; 0 cancels it. */
    fun show(context: Context, seconds: Int) {
        runCatching {
            context.contentResolver.call(uri, "countdown", null, Bundle().apply {
                putInt("seconds", seconds)
            })
        }
    }
}
