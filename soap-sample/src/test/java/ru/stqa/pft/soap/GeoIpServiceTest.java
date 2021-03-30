package ru.stqa.pft.soap;

import lavasoft.GeoIPService;
import lavasoft.GeoIPServiceSoap;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTest {
  @Test
  public void testMyIp(){
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("93.100.213.198");
    System.out.println(ipLocation);
    assertEquals(ipLocation,"<GeoIP><Country>RU</Country><State>66</State></GeoIP>");
  }

}
