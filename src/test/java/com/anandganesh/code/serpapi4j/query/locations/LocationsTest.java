package com.anandganesh.code.serpapi4j.query.locations;

import com.google.gson.JsonArray;
import com.anandganesh.code.serpapi4j.SerpApiUnitTest;
import com.anandganesh.code.serpapi4j.client.SerpApiSyncClient;
import com.anandganesh.code.serpapi4j.exceptions.SerpApiException;
import com.anandganesh.code.serpapi4j.model.responses.LocationsResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LocationsTest extends SerpApiUnitTest {
  private SerpApiSyncClient client;

  @Before
  public void testSetup() throws SerpApiException {
    client = new SerpApiSyncClient();
  }

  @After
  public void testTeardown() throws IOException {
    if (client != null) {
      client.close();
    }
  }

  @Test
  public void locationsTest() throws SerpApiException {
    LocationsResponse locationsResponse = client.locations("San Jose", 3);
    JsonArray locations = locationsResponse.getJsonArray();
    Assert.assertEquals(10, locations.size());
  }
}