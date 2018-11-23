package myspringboot.crudcloudant;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import myspringboot.crudcloudant.user.UserControllerTest;

@RunWith(Suite.class)
@SuiteClasses({ CrudcloudantApplicationTests.class, UserControllerTest.class })
public class AllTests {

}
