package com.javatechie.pm.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doReturn;

import com.javatechie.pm.api.dto.OrderRequest;
import com.javatechie.pm.api.dto.OrderResponse;
import com.javatechie.pm.api.service.OrderService;
import com.javatechie.pm.api.util.NotificationUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.javatechie.pm.api.*")
/* Instead of specify the notification looked in directly, the class we can specify the package. So that there may be a chance we can have multiple static method or multiple different packages Specify the package. Fully qualified names. Need the buckets from the zomatiki Turn power off. Cbi.star  */
public class PowermockApiApplicationTest {
  @InjectMocks
  private OrderService service;

  OrderRequest request = new OrderRequest(
    111,
    "Mobile",
    1,
    10000,
    "test@gmail.com",
    true
  );

  /* Who is the initial I Java more connotation? Okay, you don't static class, so let me do it. Before before. so before run our taste case into electrical first So now lets write a method. Putting the power up to taste our  */
  @Before
  public void init() {
    MockitoAnnotations.initMocks(NotificationUtil.class);
  }

  @Test
  public void testStaticMethods() {
    // Given
    String emailId = "test@gmail.com";
    PowerMockito.mockStatic(NotificationUtil.class);
    // When
    when(NotificationUtil.sendEmail(emailId)).thenReturn("success");
    // Then
    OrderResponse response = service.checkoutOrder(request);

    assertEquals("success", response.getMessage());
  }

  @Test
  public void testPrivateMethods() {
    // When
    /* So where here we need to instead of directly mob, we need to Despite spy means first, it will instantiate. That object, then it will inject. So we want to spy our order service. Auto subbies. In Powermac.  */

    OrderService spy = PowerMockito.spy(service);
    try {
      doReturn(2000).when(spy, "addDiscount", ArgumentMatchers.any());
    } catch (Exception e) {
      e.printStackTrace();
    }
    // Then
    // Then just invoke your orders of this checkout one S that we can compare the original price with our expected price after discount. Ok, so let us move to the
    OrderResponse response = spy.checkoutOrder(request);
    int price = response.getResponse().getPrice(); // 9000
    System.out.println("price : " + price);
    assertEquals(8000, price);
    /* You can take here. You are getting success. Now lets go to the console. There is no print statement. Means the request is not coming to this ad discount method. Whenever this R discount method, we are invoking from checkout order, it will mark the data, and it will forcefully return the 1000. So give. So give 1000 discount. So based on one 3rd thousand discount, the amount will be your 9000 Let's change the mock data. Let's go to our Karma application test here forcefully, I am returning the discount amount is 2000. So if my product is 10,000 and my discount amount is 2000 the product price should be 8000. So here I am comparing with 9000 And this let me print this price It should grip 8000 The spread that price. Ok, so this test execution should fail As we are comparing 9000 but actually it should give 8000. So let's run this once again to prove it. Yep. You can observe consular getting the price is 8000. Test case got failed, right? So that's what the power of mockito. Instead of call my original private method, I mock the data and the amount, the return which I will set directly the same return type. You can catch in our method call, ok, here in discount. Go to the taste case. But we know we are getting 8000. So now it will be result will be true. So it will be true. Our taste will be passed successfully. Let's. taste both. Let's run our application. Go to the JME Ron's to let me do it. Drawn 2 by two test case. There is no error, no failure. Both the test case got passed. Test, private method, test static method. OK. the way we did for the private method. Same we can do for the final method. Simply just mark the data. Mark that final method and compare with your service method, ok? yep, that's it about this particular video. Here we will learn how to write unit test case for private static and final method, using power mark api. */
  }
}
