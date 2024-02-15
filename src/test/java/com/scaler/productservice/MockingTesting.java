package com.scaler.productservice;

import com.scaler.productservice.exception.ProductNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MockingTesting {



    @Test
    @DisplayName("Testing...")
    public void testMoacking() {


        Throwable exception = assertThrows(ProductNotFoundException.class, () -> {
            throw new ProductNotFoundException("Product not found");
        });
        assertEquals("Product not found", exception.getMessage());




//        Dictionary mockDictionary = Mockito.mock(Dictionary.class);
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100,mockList.size());
    }
}
