package com.skaggsm.jmumblelink;

import java.io.IOException;

/**
 * Created by Mitchell Skaggs on 5/11/2019.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        try (MumbleLink link = new MumbleLinkImpl()) {
            long start = System.currentTimeMillis();
            do {
                link.setUiVersion(2);
                link.incrementUiTick();
                link.setName("Test app");
                link.setAvatarPosition(new float[]{
                        0f, 0f, 0f
                });
            } while (System.currentTimeMillis() - start <= 30000);
        }

    }
}
