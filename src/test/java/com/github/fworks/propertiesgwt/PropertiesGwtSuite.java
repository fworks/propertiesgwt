package com.github.fworks.propertiesgwt;

import com.github.fworks.propertiesgwt.client.PropertiesGwtTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class PropertiesGwtSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for PropertiesGwt");
    suite.addTestSuite(PropertiesGwtTest.class);
    return suite;
  }
}
