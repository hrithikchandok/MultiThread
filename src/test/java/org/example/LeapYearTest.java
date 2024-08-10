package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {


  @Test
  void testCase1()
  {
      assertTrue(LeapYear.isLeap(1992));

  }
    @Test
    void testCase2()
    {
        assertFalse(LeapYear.isLeap(1993));

    }
    @Test
    void testCase3()
    {
        assertTrue(LeapYear.isLeap(2008));

    }
}