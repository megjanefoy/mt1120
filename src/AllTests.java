import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ checkoutTest.class, inventoryTest.class, rentalAgreementTest.class, toolTest.class })
public class AllTests {

}
