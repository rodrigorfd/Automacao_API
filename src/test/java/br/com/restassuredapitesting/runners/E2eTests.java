package br.com.restassuredapitesting.runners;


import br.com.restassuredapitesting.tests.booking.tests.DeleteBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.GetBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.PostBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.PutBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.E2eTests.class)
@Suite.SuiteClasses({
        PostBookingTest.class,
        PutBookingTest.class,
        GetBookingTest.class,
        DeleteBookingTest.class
})
public class E2eTests {
}
