package io.jammy.common.android;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.graphics.Color;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith (AndroidJUnit4.class)
public class ExampleInstrumentedTest {

  @Test
  public void useAppContext() throws Exception {

    // Context of the app under test.
    Context appContext = InstrumentationRegistry.getTargetContext();

    assertEquals("io.jammy.common.test", appContext.getPackageName());
  }

  @Test
  public void testApplyAlpha() throws Exception {

    int colour = Color.parseColor("#ffffffff");
    int redHalfOpaque = Color.parseColor("#80ffffff");
    int redTransparent = Color.parseColor("#00ffffff");

    int colourStill = Colour.applyAlpha(colour, 1.0f);
    int halfOpaque = Colour.applyAlpha(colour, 0.5f);
    int transparent = Colour.applyAlpha(colour, 0.0f);

    assertThat(colour, is(colourStill));
    assertThat(redHalfOpaque, is(halfOpaque));
    assertThat(redTransparent, is(transparent));

  }
}
