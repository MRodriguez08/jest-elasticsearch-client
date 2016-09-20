package com.mrdevelop.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrdevelop.App;
import com.mrdevelop.model.Car;
import com.mrdevelop.service.CarService;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;

public class CarServiceImpl implements CarService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public List<Car> findAllByFilter(String filter) {
		List<Car> cars = new ArrayList<Car>();
		JestClient client = null;
		try {
			LOGGER.debug("creating elasticsearch jest client");

			JestClientFactory factory = new JestClientFactory();
			factory.setHttpClientConfig(
					new HttpClientConfig.Builder("http://localhost:9200").multiThreaded(true).build());
			client = factory.getObject();

			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchQuery("name", filter));
			//searchSourceBuilder.query(QueryBuilders.matchQuery("engine.layout", "v10"));

			Search search = new Search.Builder(searchSourceBuilder.toString())
					.addIndex("cars").build();

			LOGGER.debug("executing query:");
			LOGGER.debug("\n{}", searchSourceBuilder.toString());
			SearchResult results = client.execute(search);

			List<SearchResult.Hit<Car, Void>> hits = results.getHits(Car.class);
			for (Hit<Car, Void> car : hits){
				cars.add(car.source);
			}
			LOGGER.debug("number of hits: {}", cars.size());
			
			LOGGER.debug("closing client");
			client.shutdownClient();
		} catch (IOException e) {
			
		} finally {
			if (client != null) {
				client.shutdownClient();
			}
		}
		return cars;
	}

}
