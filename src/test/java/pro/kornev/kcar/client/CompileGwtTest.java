package pro.kornev.kcar.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileGwtTest extends GWTTestCase {
  
  @Override
  public String getModuleName() {
    return "pro.kornev.kcar.KcarWebConsole";
  }

  public void testSandbox() {
    assertTrue(true);
  }
  
}
