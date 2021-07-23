package com.jmavarez.materialcalendar.util;

import ohos.agp.components.Component;
import ohos.app.Context;

/**
 * Type of Canvas helper util.
 */
public class CanvasHelper {

    private CanvasHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static int dpToPx(Context context, int dp) {
        return dp * context.getResourceManager().getDeviceCapability().screenDensity / 160;
    }

    public static float dpToPx(Context context, float dp) {
        return dp * context.getResourceManager().getDeviceCapability().screenDensity / 160;
    }

    public static float dpToPx(Component view, int size) {
        return dpToPx(view.getContext(), size);
    }

    public static int pxToDp(Context context, int size) {
        return size / ( context.getResourceManager().getDeviceCapability().screenDensity / 160 );
    }
}
