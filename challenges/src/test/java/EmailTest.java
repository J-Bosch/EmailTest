import flow.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(JUnit4.class)
public class EmailTest {

  @Test
  public void testRun_AdapterIsCompliantWithProtocol_AppHasHelloMessage() throws Exception {
    IAgent user = new UserAgent();
    Map<String, IAdapter> adapters = new HashMap<>();
    adapters.put("EMAIL", new EmailAdapter());

    EmailApp app = new EmailApp();
    Engine engine = new Engine(user, adapters, app);
    engine.run();
    Assert.assertEquals("hello", app.popMessage());
  }

  private class UserAgent implements IAgent {
    @Override
    public List<IAction> act() throws AgentException {
      List<IAction> lact = new ArrayList<>();
      IAction iact = new userAction();
      lact.add(iact);
      return lact;
    }

    private class EmailAdapter implements IAdapter {
      @Override
      public IEvent adapt(Object o) throws AdapterException, ActionException {
        IEvent iadapt = IEvent();
        return iadapt;
      }
    }

    private class userAction implements IAction {
      @Override
      public Object execute() throws ActionException {
        return null;
      }

      @Override
      public String getType() {
        return "hello";
      }
    }
  }
}


