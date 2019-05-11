package com.skaggsm.mumblelink;

import java.io.IOException;

/**
 * Created by Mitchell Skaggs on 5/11/2019.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        try (MumbleLink link = new MumbleLink()) {
            long start = System.currentTimeMillis();
            do {
                link.setUiVersion(2);
                link.incrementUiTick();
                link.setName("Test app");
            } while (System.currentTimeMillis() - start <= 30000);
        }

    }
}
