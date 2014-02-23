package testMockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.santschi.CoffeMachine;
import com.santschi.Container;
import com.santschi.Portion;

@RunWith(MockitoJUnitRunner.class)  
public class CoffeeMachineTest {  
      
    CoffeMachine coffeeMachine;  
      
    @Mock  
    Container coffeeContainer;  
    @Mock  
    Container waterContainer;  
  
    @Before  
    public void setUp() {  
        coffeeMachine = new CoffeMachine(coffeeContainer, waterContainer);  
    }  
  
    @After  
    public void tearDown() {  
        coffeeContainer = null;  
        waterContainer = null;  
        coffeeMachine = null;         
    }  
  
    @Test  
    public void testMakeCoffe() {  
          
        when(coffeeContainer.getPortion(Portion.LARGE)).thenReturn(true);  
        when(waterContainer.getPortion(Portion.LARGE)).thenReturn(true);  
          
        assertTrue(coffeeMachine.makeCoffee(Portion.LARGE));  
    }  
      
    @Test  
    public void testNotEnoughException() {  
          
        when(coffeeContainer.getPortion(Portion.SMALL)).thenReturn(true);  
        when(waterContainer.getPortion(Portion.SMALL)).thenReturn(false);  
  
        assertFalse(coffeeMachine.makeCoffee(Portion.SMALL));  
          
    }  
  
} 